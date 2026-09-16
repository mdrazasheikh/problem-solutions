---
title: Conversation Insight
slug: conversation-insight
tags: [hashmap, string, aggregation, one-pass]
aliases: [message counts by author, average user message length]
time: O(m)
space: O(a)
---

# Conversation Insight

Summarizes message counts by author and the average user message length.

Approach: aggregate messages in one pass and compute the average from the totals.

Complexity: O(m) time and O(a) space for m messages and a authors.
