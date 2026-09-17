---
title: Heap Sort
slug: heap-sort
pattern: sorting
tags: [sorting, heap, in-place, recursion]
aliases: [max heap sort, sift down]
time: O(n log n)
space: O(log n)
---

# Heap Sort

Sorts an integer array using an in-place max heap.

Approach: build the heap bottom-up, then repeatedly swap the root to the end of the
unsorted region and sift the new root back down.

Complexity: O(n log n) time. The array is sorted in place, but `heapify` recurses, so the
call stack costs O(log n) — this is not a constant-space sort as written. An iterative
sift-down would make it O(1).
