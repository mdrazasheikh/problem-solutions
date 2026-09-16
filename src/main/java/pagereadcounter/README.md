---
title: Maximum Twin Pair Sum
slug: maximum-twin-pair-sum
tags: [linked-list, deque, two-pointer]
aliases: [maximum pages, twin sum of a linked list, max sum of first and last pair]
time: O(n)
space: O(n)
---

# Maximum Twin Pair Sum

Finds the largest sum of a "twin" pair in a singly linked list — the first node paired
with the last, the second with the second-to-last, and so on.

Approach: copy the list into a deque, then repeatedly pop from both ends and keep the
largest pair total.

Complexity: O(n) time and O(n) space for the deque.

Note: a two-pass approach (find the middle, reverse the second half, walk both halves
together) solves this in O(1) auxiliary space.
