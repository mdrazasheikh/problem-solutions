---
title: Top K Frequent Elements
slug: top-k-frequent-elements
leetcode: 347
difficulty: Medium
pattern: heap
tags: [heap, priority-queue, hashmap, counting, bucket-sort, array]
aliases: [k most frequent numbers, most common elements]
time: O(n log k)
space: O(n)
---

# Top K Frequent Elements

Returns the `k` values that occur most often in an array. Both implementations start by
counting occurrences into a map; they differ in how they pick the top `k` out of it.

## Two implementations

`topKFrequent` — a **min**-heap capped at `k` entries. Each entry is offered, and the
smallest is evicted whenever the heap grows past `k`, so what survives is the `k` largest
counts. Ordering by the smallest is what makes the cheap eviction possible: the element to
discard is always the one at the top.

Complexity: O(n log k) time and O(n) space for the frequency map. Because `k` is usually
far smaller than the number of distinct values, this beats sorting every entry.

`topKFrequentBucketSort` — index an array of lists by frequency. A value seen `f` times
goes in `bucket[f]`, and since no value can occur more than `nums.length` times, the
buckets fit in a single array. Walking it from the top down yields values in decreasing
frequency.

Complexity: O(n) time and O(n) space — no comparisons at all, which is what drops the
`log k`.

The two return the same values in different orders: the heap yields ascending frequency,
the buckets descending. The problem does not constrain the order.

## Known gaps

Both assume `k` is at most the number of distinct values. Verified by running them:

| Call | `topKFrequent` | `topKFrequentBucketSort` |
|------|----------------|--------------------------|
| `{1,1}`, k=2 | throws `NullPointerException` | `[1, 0]` |
| `{}`, k=1 | throws `NullPointerException` | `[0]` |

- The heap version polls `k` times regardless of how many entries it holds, so a poll past
  the end returns `null` and `getKey()` throws.
- The bucket version leaves the unfilled tail of `res` at its default `0`, which is
  indistinguishable from a genuine answer of `0`.

Either rejecting `k > frequency.size()` up front, or sizing the result to
`Math.min(k, frequency.size())`, would settle both.

`topKFrequentBucketSort` also allocates `new List[nums.length + 1]`, a raw type, which is
why the build reports an unchecked warning. Generic arrays cannot be created directly; the
usual workarounds are `@SuppressWarnings("unchecked")` on a cast, or a
`List<List<Integer>>` instead of an array.
