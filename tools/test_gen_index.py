#!/usr/bin/env python3
"""Tests for tools/gen_index.py. Run: python3 tools/test_gen_index.py"""

import tempfile
import unittest
from pathlib import Path

import gen_index


def write(path, text):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(text, encoding="utf-8")


def frontmatter(title, slug, tags="", aliases="", time="O(n)", space="O(1)", status=""):
    lines = [f"title: {title}", f"slug: {slug}"]
    if status:
        lines.append(f"status: {status}")
    if tags:
        lines.append(f"tags: [{tags}]")
    if aliases:
        lines.append(f"aliases: [{aliases}]")
    lines += [f"time: {time}", f"space: {space}"]
    return "---\n" + "\n".join(lines) + "\n---\n\n# " + title + "\n\nBody.\n"


class RepoFixture(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        self.root = Path(self.tmp.name)
        self.addCleanup(self.tmp.cleanup)
        write(
            self.root / "README.md",
            f"# Solutions\n\nIntro.\n\n{gen_index.BEGIN}\nold\n{gen_index.END}\n\nFooter.\n",
        )

    def solution(self, lang, directory, **kwargs):
        write(
            self.root / "src" / "main" / lang / directory / "README.md",
            frontmatter(**kwargs),
        )


class ParseFrontmatter(unittest.TestCase):
    def test_parses_scalars_and_lists(self):
        meta = gen_index.parse_frontmatter(
            frontmatter("Two Sum", "two-sum", tags="hashmap, array", aliases="pair sum")
        )
        self.assertEqual(meta["title"], "Two Sum")
        self.assertEqual(meta["slug"], "two-sum")
        self.assertEqual(meta["tags"], ["hashmap", "array"])
        self.assertEqual(meta["aliases"], ["pair sum"])
        self.assertEqual(meta["time"], "O(n)")

    def test_returns_none_without_frontmatter(self):
        self.assertIsNone(gen_index.parse_frontmatter("# Plain\n\nNo frontmatter.\n"))

    def test_rejects_malformed_line(self):
        with self.assertRaises(gen_index.IndexError_):
            gen_index.parse_frontmatter("---\ntitle: X\nslug\n---\n")


class Collect(RepoFixture):
    def test_pairs_languages_by_slug(self):
        self.solution("java", "longestsubstring", title="Longest Substring", slug="lss")
        self.solution("kotlin", "longestSubstring", title="Longest Substring", slug="lss")
        problems = gen_index.collect(self.root)
        self.assertEqual(list(problems), ["lss"])
        self.assertEqual(
            problems["lss"]["links"],
            {
                "Java": "src/main/java/longestsubstring",
                "Kotlin": "src/main/kotlin/longestSubstring",
            },
        )

    def test_unpaired_solution_has_one_link(self):
        self.solution("java", "movezeros", title="Move Zeros", slug="move-zeros")
        problems = gen_index.collect(self.root)
        self.assertEqual(list(problems["move-zeros"]["links"]), ["Java"])

    def test_skips_readme_without_frontmatter(self):
        write(self.root / "src/main/kotlin/README.md", "# Kotlin notes\n")
        self.assertEqual(gen_index.collect(self.root), {})

    def test_finds_nested_solution(self):
        self.solution("java", "db/livecoding", title="Event Dispatcher", slug="dispatch")
        problems = gen_index.collect(self.root)
        self.assertEqual(
            problems["dispatch"]["links"]["Java"], "src/main/java/db/livecoding"
        )

    def test_merges_tags_across_languages(self):
        self.solution("java", "a", title="T", slug="s", tags="sliding-window, hashmap")
        self.solution("kotlin", "b", title="T", slug="s", tags="hashmap, string")
        tags = gen_index.collect(self.root)["s"]["tags"]
        self.assertEqual(tags, ["sliding-window", "hashmap", "string"])

    def test_rejects_missing_slug(self):
        write(
            self.root / "src/main/java/x/README.md",
            "---\ntitle: X\ntime: O(n)\n---\n\n# X\n",
        )
        with self.assertRaises(gen_index.IndexError_):
            gen_index.collect(self.root)

    def test_rejects_duplicate_slug_in_same_language(self):
        self.solution("java", "a", title="T", slug="dupe")
        self.solution("java", "b", title="T", slug="dupe")
        with self.assertRaises(gen_index.IndexError_):
            gen_index.collect(self.root)


class Render(RepoFixture):
    def test_table_marks_missing_language(self):
        self.solution("java", "movezeros", title="Move Zeros", slug="move-zeros")
        table = gen_index.render_table(gen_index.collect(self.root))
        self.assertIn("[src](src/main/java/movezeros)", table)
        self.assertIn(gen_index.NONE, table.splitlines()[-1])

    def test_aliases_are_searchable_in_the_row(self):
        self.solution(
            "java", "lus", title="Longest Unique Subarray", slug="lus",
            aliases="contiguous subarray no duplicates",
        )
        table = gen_index.render_table(gen_index.collect(self.root))
        self.assertIn("aka contiguous subarray no duplicates", table)

    def test_rows_sorted_by_title(self):
        self.solution("java", "z", title="Alpha", slug="a")
        self.solution("java", "a", title="Zulu", slug="z")
        rows = gen_index.render_table(gen_index.collect(self.root)).splitlines()[2:]
        self.assertTrue(rows[0].startswith("| Alpha"))
        self.assertTrue(rows[1].startswith("| Zulu"))

    def test_tag_index_separates_multiple_language_links(self):
        self.solution("java", "a", title="Shared", slug="shared", tags="t")
        self.solution("kotlin", "a", title="Shared", slug="shared", tags="t")
        tag_index = gen_index.render_tag_index(gen_index.collect(self.root))
        self.assertIn("Shared [j](src/main/java/a) [k](src/main/kotlin/a)", tag_index)

    def test_tag_index_groups_problems(self):
        self.solution("java", "a", title="A", slug="a", tags="bfs")
        self.solution("java", "b", title="B", slug="b", tags="bfs, graph")
        tag_index = gen_index.render_tag_index(gen_index.collect(self.root))
        self.assertIn("**`bfs`** — A [j](src/main/java/a), B [j](src/main/java/b)", tag_index)
        self.assertIn("**`graph`** — B", tag_index)

    def test_summary_counts_both_language_solutions(self):
        self.solution("java", "a", title="Shared", slug="shared")
        self.solution("kotlin", "a", title="Shared", slug="shared")
        self.solution("java", "b", title="JavaOnly", slug="java-only")
        block = gen_index.render(gen_index.collect(self.root))
        self.assertIn("**2 problems** — 2 in Java, 1 in Kotlin, 1 solved in both.", block)


class Status(RepoFixture):
    def test_stub_is_marked_in_the_table(self):
        self.solution("java", "lot", title="Level Order", slug="lot", status="stub")
        table = gen_index.render_table(gen_index.collect(self.root))
        self.assertIn(f"Level Order {gen_index.STATUS_MARK} _stub_", table)

    def test_row_without_status_has_no_marker(self):
        self.solution("java", "ms", title="Merge Sort", slug="ms")
        table = gen_index.render_table(gen_index.collect(self.root))
        self.assertNotIn(gen_index.STATUS_MARK, table)


class Splice(RepoFixture):
    def test_replaces_only_between_markers(self):
        self.solution("java", "a", title="A", slug="a")
        updated = gen_index.build(self.root)
        self.assertTrue(updated.startswith("# Solutions\n\nIntro.\n"))
        self.assertTrue(updated.endswith("\n\nFooter.\n"))
        self.assertNotIn("old", updated)

    def test_is_idempotent(self):
        self.solution("java", "a", title="A", slug="a")
        first = gen_index.build(self.root)
        (self.root / "README.md").write_text(first, encoding="utf-8")
        self.assertEqual(gen_index.build(self.root), first)

    def test_rejects_readme_without_markers(self):
        write(self.root / "README.md", "# Solutions\n")
        with self.assertRaises(gen_index.IndexError_):
            gen_index.build(self.root)


class Cli(RepoFixture):
    def test_check_fails_when_stale_then_passes_after_write(self):
        self.solution("java", "a", title="A", slug="a")
        self.assertEqual(gen_index.main(["--check", "--repo-root", str(self.root)]), 1)
        self.assertEqual(gen_index.main(["--repo-root", str(self.root)]), 0)
        self.assertEqual(gen_index.main(["--check", "--repo-root", str(self.root)]), 0)


if __name__ == "__main__":
    unittest.main(verbosity=2)
