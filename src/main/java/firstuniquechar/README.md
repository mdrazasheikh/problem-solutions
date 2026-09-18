---
title: First Unique Character
slug: first-unique-character
leetcode: 387
difficulty: Easy
pattern: hashing
tags: [array, counting, string]
aliases: [first non repeating character]
time: O(n)
space: O(1)
---

# First Unique Character

Returns the first character that appears exactly once in a string.

Approach: tally the characters into a fixed 26-slot array, then scan the string in order
and return the first character whose tally is one.

Complexity: O(n) time and O(1) space — the tally is a fixed 26 entries, not a map that
grows with the input.

Note: the tally is indexed by `c - 'a'`, so the input must be lowercase a-z. Anything else
throws `ArrayIndexOutOfBoundsException`.
