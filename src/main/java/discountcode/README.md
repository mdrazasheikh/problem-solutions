---
title: Discount Code
slug: discount-code
tags: [string, stack, reduction]
aliases: [valid discount coupon, reduce string by cancelling adjacent pairs]
time: O(n)
space: O(n)
---

# Discount Code

Returns one flag per discount code: 1 when the code is valid, 0 when it is not.

A code is valid when it is empty, or a valid code wrapped in a matching pair of
characters, or two valid codes side by side. So `aa` is valid, `abba` is `a` wrapping
`bb`, and `daabbd` is `d` wrapping `aabb`, itself `aa` next to `bb`.

Approach: every code built by those rules collapses to nothing if adjacent equal
characters are deleted repeatedly, and only such codes do, so a single stack pass decides
it. A character equal to the top of the stack cancels with it; anything else is pushed.
The code is valid when the stack ends empty.

Complexity: O(n) time and O(n) space per code.

Note: the earlier version peeled a matching prefix and suffix and asked whether the two
remaining halves were palindromes. That rule rejects `aabb`, which is valid, because its
first and last characters do not match — a peel-and-split test cannot see a code that is
two valid codes side by side rather than one wrapped code.
