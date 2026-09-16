---
title: Search Suggestions System
slug: search-suggestions-system
tags: [string, prefix, autocomplete]
aliases: [suggestions per growing prefix, typeahead over a list]
time: O(p * r)
space: O(p)
---

# Search Suggestions

Returns repository suggestions for each growing prefix of a customer query.

Approach: filter matching repository entries and retain the first three suggestions per prefix.

Complexity: O(p * r) in the direct scan, where p is query length and r is repository size.
