---
title: Move Zeroes
slug: move-zeroes
tags: [array, two-pointer, in-place]
aliases: [move zeros to the end, stable partition]
time: O(n)
space: O(1)
---

# Move Zeros

Moves every zero in an integer array to the end while keeping the order of the non-zero elements.

Approach: one pass copies non-zero elements to the next insert position, then the tail of the array is filled with zeros.

Complexity: O(n) time and O(1) auxiliary space.
