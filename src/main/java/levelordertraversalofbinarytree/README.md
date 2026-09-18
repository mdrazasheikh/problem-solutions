---
title: Level Order Traversal
slug: level-order-traversal
leetcode: 102
difficulty: Medium
pattern: bfs
status: stub
tags: [bfs, binary-tree, queue]
aliases: [breadth first tree traversal, print tree by levels]
time: O(n)
space: O(w)
---

# Level Order Traversal

**Stub — not implemented yet.** The class holds a list of values and a commented-out
`main`; there is no traversal code.

Intended approach: seed a queue with the root, then repeatedly drain one level's worth of
nodes, emitting their values and enqueuing their children.

Intended complexity: O(n) time and O(w) space, where w is the maximum tree width.

See [Graph Valid Tree](../graphtree) for a working BFS in this repo.
