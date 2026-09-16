---
title: Spiral Matrix
slug: spiral-matrix
tags: [matrix, simulation, boundaries]
aliases: [spiral order traversal, clockwise matrix walk]
time: O(mn)
space: O(1)
---

# Spiral Traversal

Returns a matrix's values in clockwise spiral order.

Approach: shrink top, bottom, left, and right boundaries after each edge traversal.

Complexity: O(mn) time and O(1) auxiliary space, excluding the output list.
