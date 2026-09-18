---
title: Group Anagrams
slug: group-anagrams
leetcode: 49
difficulty: Medium
pattern: hashing
tags: [hashmap, sorting, string]
aliases: [group words with the same letters, anagram buckets]
time: O(w * k log k)
space: O(w * k)
---

# Grouped Anagram

Groups words that contain the same letters with the same frequencies.

Approach: use a canonical sorted-character key for each word.

Complexity: O(w * k log k) time and O(w * k) space for w words of average length k.
