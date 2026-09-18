---
title: Merge Intervals
slug: merge-intervals
pattern: intervals
leetcode: 56
difficulty: Medium
tags: [intervals, sorting, greedy, array]
aliases: [combine overlapping ranges, merge overlapping intervals]
time: O(n log n)
space: O(n)
---

# Merge Intervals

Collapses a list of `[start, end]` intervals so that every overlapping or touching pair
becomes one interval.

Approach: sort by start, then sweep once. Because the intervals are ordered by start, any
interval that overlaps the one being built must start before that one ends, so a single
comparison against the last result decides it — extend the end, or begin a new interval.
No lookahead and no second pass are needed.

`current[0] <= previous[1]` uses `<=`, so touching intervals merge: `[1,4]` and `[4,5]`
become `[1,5]`. Using `<` would keep them apart.

Complexity: O(n log n) time, dominated by the sort, and O(n) space for the result.

## Known gaps

- **An empty input throws.** `result.add(intervals[0])` runs before any length check, so
  `mergeIntervals(new int[][]{})` throws `ArrayIndexOutOfBoundsException` rather than
  returning an empty array.
- **The caller's array is modified.** Two separate effects, both confirmed by calling it
  and then inspecting the argument:
  - `Arrays.sort(intervals, ...)` reorders the caller's array in place.
  - The result holds references to the original rows, not copies, so `previous[1] =
    Math.max(...)` writes through to them. After merging `{{1,3},{2,6}}` the argument
    reads `[[1,6],[2,6]]` — the first row rewritten, the second left stale.

  Copying the rows into the result, or sorting a clone, would leave the input untouched.

`result.getLast()` is the Java 21 `SequencedCollection` method, which is why this needs a
recent JDK.
