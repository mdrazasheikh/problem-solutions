---
title: Add Two Numbers
slug: add-two-numbers
leetcode: 2
difficulty: Medium
pattern: linked-list
tags: [linked-list, math, carry]
aliases: [sum two numbers stored as linked lists]
time: O(max(m, n))
space: O(1)
---

# Add Two Numbers

Adds two non-negative integers represented by reverse-order linked lists.

Approach: walk both lists together, carrying values above 9 into the next node.

Complexity: O(max(m, n)) time and O(1) auxiliary space, excluding the output list.
