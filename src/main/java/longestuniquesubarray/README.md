---
title: Longest Unique Subarray
slug: longest-unique-subarray
pattern: sliding-window
tags: [sliding-window, hashset, hashmap, array, two-pointers]
aliases: [longest contiguous subarray with no duplicate values, longest distinct subarray]
time: O(n)
space: O(n)
---

# Longest Unique Subarray

Returns the length of the longest contiguous subarray whose values are all distinct. The
array equivalent of [Longest Substring Without Repeating
Characters](../longestsubstring).

Two implementations:

- `longestUniqueSubArray` — a set holding the current window. When the right value is
  already present, shrink from the left until it is not.
- `longestUniqueSubArray2` — a map of each value's last index, so the left edge jumps
  straight past the previous occurrence instead of stepping.

Complexity: O(n) time for both; each index enters and leaves the window at most once.
O(n) space for the set or map.
