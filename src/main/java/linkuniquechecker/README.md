---
title: Link Unique Checker
slug: link-unique-checker
tags: [string, substring, normalization]
aliases: [are two links the same, near duplicate url]
time: O(n^2)
space: O(n)
---

# Link Unique Checker

Checks whether two encoded links are equivalent under the normalization rules in the
implementation: lowercase them, then accept a match if one is a prefix or suffix slice of
the other with at most one leftover character.

Approach: compare the shorter link's leading and trailing slices against the longer one
with `contains` and `replace`.

Complexity: O(n^2) time — each of the constant number of candidate slices runs a
`contains` scan — and O(n) space for the substrings and replacement copies.
