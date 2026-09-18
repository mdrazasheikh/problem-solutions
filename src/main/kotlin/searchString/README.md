---
title: Design Search Autocomplete
slug: design-search-autocomplete
leetcode: 642
difficulty: Hard
pattern: prefix-search
tags: [trie, string, autocomplete, design, prefix]
aliases: [autocomplete system, trie suggestions]
time: O(p + r)
space: O(n * l)
---

# Search String

Provides autocomplete suggestions for a search string using a trie of stored sentences.

Approach: `insert` walks the sentence character by character, creating trie nodes as
needed and recording the whole sentence on every node it passes. `suggest` descends the
trie along the prefix and returns the list held at the node it lands on, so no subtree
walk or filtering is needed at query time.

Complexity: `insert` is O(L) for a sentence of length L; `suggest` is O(P) for a prefix of
length P, plus the cost of reading the R results. Space is O(n * l) across n sentences of
average length l, because storing the sentence at every node on its path is what buys the
O(P) query.

Note: `suggest` hands back the node's own mutable list rather than a copy, so a caller can
modify the index.
