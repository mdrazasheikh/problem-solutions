---
title: Count of Balloon
slug: count-of-balloon
tags: [hashmap, counting, string]
aliases: [maximum number of balloons, form word from letters]
time: O(n)
space: O(1)
---

# Count Of Balloon

Finds how many times the word `balloon` can be formed from the characters of a string.

Two implementations:

- `countOfBalloon` — counts the string into a `HashMap`, then for each letter of `balloon`
  divides how many are available by how many are required, taking the smallest result.
- `maxNumberOfBalloons` — the same idea over a fixed 26-slot array, halving the counts of
  the doubled letters `l` and `o` directly.

Complexity: O(n) time and O(1) space for both; the tally is bounded by the alphabet rather
than the input length.
