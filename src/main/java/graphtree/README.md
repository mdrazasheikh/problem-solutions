---
title: Graph Valid Tree
slug: graph-valid-tree
leetcode: 261
difficulty: Medium
pattern: bfs
tags: [bfs, graph, adjacency-list, queue, connected-components]
aliases: [is this graph a tree, connected and acyclic, detect cycle undirected]
time: O(n + e)
space: O(n + e)
---

# Graph Tree

Determines whether an undirected graph is a connected acyclic tree.

Approach: reject the wrong edge count, traverse from node zero, and verify all nodes were visited.

Complexity: O(n + e) time and O(n + e) space.
