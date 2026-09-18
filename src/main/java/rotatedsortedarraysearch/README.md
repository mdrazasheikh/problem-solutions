---
title: Search in Rotated Sorted Array
slug: search-in-rotated-sorted-array
pattern: binary-search
leetcode: 33
difficulty: Medium
tags: [binary-search, array, sorted-array]
aliases: [find target in rotated array, pivoted sorted array search]
time: O(log n)
space: O(1)
---

# Search in Rotated Sorted Array

Finds the index of a target in a sorted array that has been rotated at an unknown pivot,
or -1 when it is absent.

Approach: binary search, with one extra step per iteration. A rotated array split at any
midpoint always leaves at least one half still sorted, and `nums[left] <= nums[mid]`
identifies which. Once a half is known to be sorted, its two endpoints say whether the
target can be inside it, so the search discards the other half exactly as an ordinary
binary search would.

Complexity: O(log n) time and O(1) space. The rotation costs nothing asymptotically — it
only adds the check for which half is sorted.

Note: `nums[left] <= nums[mid]` uses `<=` so that a two-element window, where `left ==
mid`, counts as a sorted left half.

## Precondition

The values must be **distinct**, which is what LeetCode 33 guarantees. Duplicates defeat
the "which half is sorted" test, because `nums[left] == nums[mid]` no longer implies the
left half is ordered. Verified: `search({1, 0, 1, 1, 1}, 0)` returns -1 although the
target sits at index 1.

That variant is LeetCode 81, and it is solved by shrinking `left` past the ambiguity when
`nums[left] == nums[mid]`, which costs O(n) in the worst case.
