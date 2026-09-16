---
title: Lucky Number
slug: lucky-number
pattern: math
tags: [recursion, math, josephus]
aliases: [josephus elimination, lucky number sieve]
time: O(log n)
space: O(log n)
---

# Lucky Number

Checks whether a number is lucky under the Josephus-style recursive elimination rule.

Approach: recursively update the position using the current elimination step.

Complexity: O(log n) time and O(log n) call-stack space.
