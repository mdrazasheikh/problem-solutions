---
title: Longest Substring Without Repeating Characters
slug: longest-substring-without-repeating-characters
pattern: sliding-window
tags: [sliding-window, hashmap, string, two-pointer]
aliases: [longest unique substring, no repeating characters]
time: O(n)
space: O(k)
---

# Longest Substring

Finds the length of the longest substring without repeated characters.

Approach: sliding window with a map of each character's most recent index.

Complexity: O(n) time and O(min(n, character-set-size)) space.
