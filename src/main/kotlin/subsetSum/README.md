---
title: Contiguous Range Sum
slug: contiguous-range-sum
pattern: sliding-window
tags: [sliding-window, array, two-pointers]
aliases: [subset sum, find a range that adds to a target]
time: O(n)
space: O(1)
---

# Subset Sum

Finds the first contiguous range whose values add up to a target, returned as a start and
end index.

Approach: sliding window over the input values, shrinking from the left whenever the
running sum overshoots the target.

Complexity: O(n) time and O(1) space — the result holds two indices regardless of input
size. The window only shrinks on an overshoot, so this is correct for non-negative values
only; a negative value can drop the sum back under the target after the window has already
moved past the answer.
