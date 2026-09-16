---
title: Search Suggestions System
slug: search-suggestions-system
tags: [string, prefix, regex, autocomplete]
aliases: [suggestions per growing prefix, typeahead over a list]
time: O(p * r * l)
space: O(p * r)
---

# Search Suggestions System

Returns repository suggestions for each growing prefix of a customer query, starting at
prefixes of length two.

Approach: for each prefix, build the regex `prefix\w*` and test every repository entry
against it.

Complexity: O(p * r * l) time for a query of length p, a repository of r entries and an
average entry length l, and O(p * r) space for the collected suggestions.

Known gaps:

- The usual statement of this problem caps each prefix at three suggestions; this
  implementation returns every match.
- A prefix is interpolated into a regex unescaped, so a query containing regex
  metacharacters is not matched literally.
- A trie would answer every prefix of one query in a single descent instead of rescanning
  the whole repository per prefix. See [Design Search
  Autocomplete](../../kotlin/searchString) for that approach.
