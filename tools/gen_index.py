#!/usr/bin/env python3
"""Generate the solution index in the root README from per-solution frontmatter.

Every solution README may start with a YAML-ish frontmatter block:

    ---
    title: Longest Substring Without Repeating Characters
    slug: longest-substring-without-repeating-characters
    tags: [sliding-window, hashmap, string]
    aliases: [longest unique substring]
    time: O(n)
    space: O(k)
    ---

Solutions that share a slug are the same problem in different languages and
collapse into a single row with one link per language.

Usage: python3 tools/gen_index.py [--check]
"""

import argparse
import re
import sys
from pathlib import Path

LANG_ROOTS = {"Java": "src/main/java", "Kotlin": "src/main/kotlin"}
LANG_ORDER = ["Java", "Kotlin"]
BEGIN = "<!-- BEGIN INDEX -->"
END = "<!-- END INDEX -->"
LIST_KEYS = {"tags", "aliases", "related"}
DIFFICULTIES = ("Easy", "Medium", "Hard")
NONE = "—"
STATUS_MARK = "⚠️"

FRONTMATTER = re.compile(r"\A---\r?\n(.*?)\r?\n---\r?\n?", re.DOTALL)


class IndexError_(Exception):
    pass


def parse_frontmatter(text):
    """Return the frontmatter dict, or None when the file has no frontmatter."""
    match = FRONTMATTER.match(text)
    if not match:
        return None
    data = {}
    for line in match.group(1).splitlines():
        line = line.strip()
        if not line or line.startswith("#"):
            continue
        if ":" not in line:
            raise IndexError_(f"frontmatter line is not 'key: value': {line!r}")
        key, _, value = line.partition(":")
        key, value = key.strip(), value.strip()
        if key in LIST_KEYS:
            data[key] = split_list(value)
        else:
            data[key] = value
    return data


def split_list(value):
    value = value.strip()
    if value.startswith("[") and value.endswith("]"):
        value = value[1:-1]
    return [item.strip() for item in value.split(",") if item.strip()]


def collect(repo_root):
    """Read every solution README and group the entries by slug."""
    problems = {}
    for lang, root in LANG_ROOTS.items():
        base = repo_root / root
        if not base.is_dir():
            continue
        for readme in sorted(base.rglob("README.md")):
            meta = parse_frontmatter(readme.read_text(encoding="utf-8"))
            if meta is None:
                continue
            slug = meta.get("slug")
            if not slug:
                raise IndexError_(f"{readme}: frontmatter has no 'slug'")
            if not meta.get("title"):
                raise IndexError_(f"{readme}: frontmatter has no 'title'")
            if not meta.get("pattern"):
                raise IndexError_(f"{readme}: frontmatter has no 'pattern'")
            entry = problems.setdefault(
                slug,
                {"title": meta["title"], "pattern": meta["pattern"], "tags": [],
             "aliases": [], "links": {}, "status": "", "leetcode": "",
             "difficulty": ""},
            )
            if lang in entry["links"]:
                raise IndexError_(f"{slug}: two {lang} directories claim this slug")
            entry["links"][lang] = readme.parent.relative_to(repo_root).as_posix()
            entry["status"] = meta.get("status", entry.get("status", ""))
            entry["leetcode"] = meta.get("leetcode", entry.get("leetcode", ""))
            difficulty = meta.get("difficulty", "")
            if difficulty and difficulty not in DIFFICULTIES:
                raise IndexError_(
                    f"{readme}: difficulty {difficulty!r} is not one of "
                    + ", ".join(DIFFICULTIES))
            if difficulty and not meta.get("leetcode"):
                raise IndexError_(
                    f"{readme}: difficulty is a LeetCode rating, so it needs a "
                    "'leetcode' number too")
            entry["difficulty"] = difficulty or entry.get("difficulty", "")
            entry["time"] = meta.get("time", NONE)
            entry["space"] = meta.get("space", NONE)
            merge(entry["tags"], meta.get("tags", []))
            merge(entry["aliases"], meta.get("aliases", []))
    return problems


def merge(target, values):
    for value in values:
        if value not in target:
            target.append(value)


def render_table(problems):
    lines = [
        "| Problem | LC | Difficulty | Pattern | Tags | Time | Space | Java | Kotlin |",
        "|---|---|---|---|---|---|---|---|---|",
    ]
    for slug in sorted(problems, key=lambda s: problems[s]["title"].lower()):
        entry = problems[slug]
        name = entry["title"]
        if entry.get("status"):
            name += f" {STATUS_MARK} _{entry['status']}_"
        if entry["aliases"]:
            name += "<br><sub>aka " + ", ".join(entry["aliases"]) + "</sub>"
        cells = [
            name,
            leetcode_cell(entry["leetcode"]),
            entry["difficulty"] or NONE,
            f"`{entry['pattern']}`",
            ", ".join(f"`{tag}`" for tag in sorted(entry["tags"])) or NONE,
            f"`{entry['time']}`",
            f"`{entry['space']}`",
        ]
        cells += [link_cell(entry["links"].get(lang)) for lang in LANG_ORDER]
        lines.append("| " + " | ".join(cells) + " |")
    return "\n".join(lines)


def leetcode_cell(number):
    """The problem number, unlinked.

    A LeetCode URL is keyed by the problem's slug rather than its number, and the site
    answers an unauthenticated request with 403 either way, so a generated link cannot be
    checked. The number alone is enough to find the problem.
    """
    return number or NONE


def link_cell(path):
    return f"[src]({path})" if path else NONE


def render_pattern_index(problems):
    """Group problems by the bucket they physically live in.

    Buckets are ordered by name rather than by size so that adding a problem does not
    reshuffle the generated sections and churn the diff.
    """
    by_pattern = {}
    for entry in problems.values():
        by_pattern.setdefault(entry["pattern"], []).append(entry)
    lines = []
    for pattern in sorted(by_pattern):
        entries = sorted(by_pattern[pattern], key=lambda e: e["title"].lower())
        lines.append(f"### {pattern} ({len(entries)})")
        lines.append("")
        for entry in entries:
            lines.append(f"- {tag_links(entry)}")
        lines.append("")
    return "\n".join(lines).rstrip()


def render_tag_index(problems):
    by_tag = {}
    for entry in problems.values():
        for tag in entry["tags"]:
            by_tag.setdefault(tag, []).append(entry)
    lines = []
    for tag in sorted(by_tag):
        entries = sorted(by_tag[tag], key=lambda e: e["title"].lower())
        links = ", ".join(tag_links(entry) for entry in entries)
        lines.append(f"- **`{tag}`** — {links}")
    return "\n".join(lines)


def tag_links(entry):
    parts = []
    for lang in LANG_ORDER:
        path = entry["links"].get(lang)
        if path:
            parts.append(f"[{lang[0].lower()}]({path})")
    return f"{entry['title']} {' '.join(parts)}"


def render(problems):
    java = sum(1 for e in problems.values() if "Java" in e["links"])
    kotlin = sum(1 for e in problems.values() if "Kotlin" in e["links"])
    both = sum(1 for e in problems.values() if len(e["links"]) == 2)
    rated = [e["difficulty"] for e in problems.values() if e["difficulty"]]
    breakdown = ", ".join(
        f"{rated.count(level)} {level.lower()}"
        for level in DIFFICULTIES if rated.count(level))
    return "\n".join(
        [
            BEGIN,
            "",
            f"**{len(problems)} problems** — {java} in Java, {kotlin} in Kotlin, "
            f"{both} solved in both.",
            "",
            f"{len(rated)} are from LeetCode ({breakdown}); the rest come from Codility,"
            " HackerRank, interviews, or are plain algorithm implementations.",
            "",
            "## All solutions",
            "",
            render_table(problems),
            "",
            "## By pattern",
            "",
            "The primary technique each problem drills. Most problems use more than one,"
            " so this is a single best answer rather than the whole story; see [By"
            " technique](#by-technique) for every technique a solution touches.",
            "",
            render_pattern_index(problems),
            "",
            "## By technique",
            "",
            render_tag_index(problems),
            "",
            END,
        ]
    )


def splice(readme_text, block):
    start = readme_text.find(BEGIN)
    end = readme_text.find(END)
    if start == -1 or end == -1:
        raise IndexError_(
            f"root README.md is missing the {BEGIN} / {END} markers"
        )
    if end < start:
        raise IndexError_(f"{END} appears before {BEGIN} in the root README.md")
    return readme_text[:start] + block + readme_text[end + len(END):]


def build(repo_root):
    readme = repo_root / "README.md"
    return splice(readme.read_text(encoding="utf-8"), render(collect(repo_root)))


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--check",
        action="store_true",
        help="exit non-zero if the index is stale instead of rewriting it",
    )
    parser.add_argument(
        "--repo-root",
        type=Path,
        default=Path(__file__).resolve().parent.parent,
    )
    args = parser.parse_args(argv)

    readme = args.repo_root / "README.md"
    try:
        updated = build(args.repo_root)
    except IndexError_ as exc:
        print(f"error: {exc}", file=sys.stderr)
        return 2

    if updated == readme.read_text(encoding="utf-8"):
        print("index is up to date")
        return 0
    if args.check:
        print("index is stale: run python3 tools/gen_index.py", file=sys.stderr)
        return 1
    readme.write_text(updated, encoding="utf-8")
    print(f"wrote index to {readme}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
