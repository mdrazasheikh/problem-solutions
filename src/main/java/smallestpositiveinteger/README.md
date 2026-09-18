---
title: Smallest Missing Positive Integer
slug: smallest-missing-positive
leetcode: 41
difficulty: Hard
pattern: hashing
tags: [array, counting, boolean-sieve]
aliases: [first missing positive, smallest positive not in array]
time: O(n)
space: O(n)
---

# Smallest Positive Integer

Finds the smallest positive integer missing from an array.

Approach: the answer can only lie in 1..n+1, so mark every in-range value in a
`boolean[n + 2]` and return the first index left unmarked.

Complexity: O(n) time and O(n) space for the marker array.

Note: the values themselves can be used as the markers, by swapping each value to its own
index, which reaches O(1) auxiliary space at the cost of mutating the input.
