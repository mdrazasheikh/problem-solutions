---
title: Search Suggestions System
slug: search-suggestions-system
tags: [string, prefix, sorting, autocomplete]
aliases: [suggestions per growing prefix, typeahead over a list]
time: O(r log r + p * r * l)
space: O(r)
---

# Search Suggestions System

Returns up to three repository suggestions for each growing prefix of a customer query,
starting at prefixes of length two.

Approach: sort the repository once, then for each prefix walk it in order and take
matching entries with `startsWith`, stopping at three. Sorting up front is what lets the
scan stop early and still return the lexicographically smallest three.

Complexity: O(r log r) to sort, then O(p * r * l) for a query of length p, a repository of
r entries and an average entry length l. O(r) space for the sorted copy, which leaves the
caller's list untouched.

Note: a trie would answer every prefix of one query in a single descent rather than
rescanning the repository per prefix, at the cost of building it. See [Design Search
Autocomplete](../../kotlin/searchString) for that approach.
