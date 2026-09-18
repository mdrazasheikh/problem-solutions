---
title: LRU Cache
slug: lru-cache
leetcode: 146
difficulty: Medium
pattern: design
tags: [design, hashmap, doubly-linked-list, cache]
aliases: [least recently used cache, eviction policy, O(1) cache]
time: O(1)
space: O(capacity)
---

# LRU Cache

Fixed-capacity key/value cache that evicts the least recently used entry when full.

Approach: a hash map for lookup plus a doubly linked list with head and tail sentinels for recency order. `get` and `put` move the node to the tail; an overflowing `put` drops the node after the head.

Complexity: O(1) time per operation and O(capacity) space.
