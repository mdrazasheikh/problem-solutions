---
title: Discount Code
slug: discount-code
tags: [string, palindrome, two-pointer]
aliases: [palindrome after insertion, valid discount string]
time: O(n)
space: O(n)
---

# Discount Code

Validates discount strings: a code is valid when it is a palindrome, or when it splits
into two palindromes after a matching prefix and suffix are peeled off.

Approach: test the whole value with a two-pointer palindrome check, then fall back to
peeling matching characters from both ends and checking the two remaining pieces.

Complexity: O(n) time per code and O(n) space for the substrings taken while splitting.

Known gaps:

- `findValidDiscountCoupons` calls `checkIfXAddedOnBothEnds(code)` and throws the result
  away, so a non-palindrome code contributes no entry at all. The returned list is shorter
  than the input list instead of holding one flag per code.
- The split points are computed as `value.substring(i, j / i - 1)` and
  `value.substring(j / i - 1, j + 1)`, which divide the end index by the start index. That
  is not a midpoint, and it only avoids dividing by zero because the method returns early
  when the first and last characters do not match.
- `System.out.println` on every code makes the function unusable as a library call.
