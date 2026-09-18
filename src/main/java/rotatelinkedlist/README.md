---
title: Rotate Linked List
slug: rotate-linked-list
leetcode: 61
difficulty: Medium
pattern: linked-list
tags: [linked-list, two-pointers, cycle]
aliases: [rotate a list right by k, ring and break]
time: O(n)
space: O(1)
---

# Rotate Linked List

Rotates a singly linked list to the right by k places.

Approach: walk to the tail to get the length, reduce k modulo the length, close the list into a ring, then step to the new tail and break the ring after it.

Complexity: O(n) time and O(1) auxiliary space.
