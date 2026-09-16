---
title: Design Search Autocomplete
slug: design-search-autocomplete
tags: [trie, string, autocomplete, design, prefix]
aliases: [leetcode 642, autocomplete system, trie suggestions]
time: O(p + r)
space: O(n)
---

# Search String

Provides autocomplete suggestions for a search string using a trie of stored sentences.

Approach: store characters in trie nodes and traverse the query prefix before collecting suggestions.

Complexity: insertion is O(L); a query is O(P + R), excluding sorting, where L is sentence length, P is prefix length, and R is returned output size.
