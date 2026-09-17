---
title: Minimum Circular Alignment Cost
slug: min-circular-alignment-cost
pattern: prefix-sum
tags: [sorting, prefix-sum, median, circular-array, greedy]
aliases: [minimum travel cost on a circle, align points around 360 degrees]
time: O(n log n)
space: O(n)
---

# Minimum Circular Alignment Cost

Finds the minimum total cost of moving every point of a circular arrangement onto a
single position, where positions wrap around at 360.

Approach: sort the input, duplicate it with +360 to linearise the wrap-around, then slide
an n-wide window over the doubled array. For each window the cheapest meeting point is
its median, and the cost is read off a prefix-sum array in constant time.

Complexity: O(n log n) time, dominated by the sort, and O(n) space for the doubled array
and prefix sums.
