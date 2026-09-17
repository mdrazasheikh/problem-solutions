---
title: Missing Dice Rolls
slug: missing-dice-rolls
pattern: greedy
tags: [math, greedy, array]
aliases: [find missing rolls for a target mean, distribute remaining total]
time: O(n + f)
space: O(f)
---

# Dice

Calculates the f missing dice rolls needed to bring n known rolls to a requested mean.

Approach: derive the total the missing rolls must add up to, reject it when it falls
outside f..6f, then start every roll at 1 and greedily pour the remainder in, at most 5
per roll.

Complexity: O(n + f) time — one pass to sum the known rolls, then at most f steps to
distribute the remainder — and O(f) space for the returned rolls.
