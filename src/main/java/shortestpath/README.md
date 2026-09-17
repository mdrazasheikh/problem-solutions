---
title: Shortest Path in a Grid
slug: shortest-path-in-a-grid
pattern: bfs
tags: [bfs, graph, matrix, queue, shortest-path]
aliases: [shortest path in binary matrix, grid bfs, maze shortest path, fewest steps through a grid]
time: O(m * n)
space: O(m * n)
---

# Shortest Path in a Grid

Finds the length of the shortest path from the top-left cell to the bottom-right cell of a
grid, where `0` is open and `1` is blocked, moving up, down, left or right. The length is
counted in cells, so a one-cell grid has length 1. Returns -1 when no path exists.

Approach: breadth-first search from `(0, 0)`. The queue is drained one level at a time —
`int size = queue.size()` before the inner loop fixes how many cells belong to the current
distance — so `distance` increments exactly once per ring of expansion. A cell is marked
visited as it is enqueued rather than as it is polled, which is what stops the same cell
being queued several times by different neighbours.

Complexity: O(m * n) time, since every cell is enqueued at most once and each is examined
against four fixed directions, and O(m * n) space for the `visited` grid and the queue.

## Design notes

- **Either endpoint being blocked rules out a path**, so the guard is `||`. An earlier
  version used `&&` and so only rejected a grid with *both* corners blocked; with just the
  start blocked, that cell was enqueued and expanded as though it were open, and the
  method reported a route through a wall.
- **Draining the queue means no path exists**, so the method returns -1 there rather than
  falling through to `return distance`. The counter at that point is however many rings
  the search managed before running out of cells, which reads like a valid answer.
- **Movement is orthogonal only.** Adding the four diagonals to `directions` turns this
  into the eight-way variant.

Note: `graph[0].length` is read before any emptiness check, so a null or zero-row grid
throws rather than returning -1.

Tests: `src/test/java/bfs/shortestpath/ShortestPathTest.java`.
