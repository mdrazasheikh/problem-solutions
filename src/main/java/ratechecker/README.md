---
title: Rate Limiter — Sliding Window
slug: rate-limiter-sliding-window
tags: [sliding-window, deque, design, rate-limiting]
aliases: [request throttling, sliding window counter, too many requests]
time: O(1) amortised
space: O(w)
---

# Rate Limiter — Sliding Window

Decides whether a request may proceed, given a cap on how many requests are allowed
within a sliding time window.

Approach: keep request timestamps in a deque. On each call, drop timestamps that have
fallen out of the window, reject if the remaining count is at the cap, and otherwise
record the new timestamp at the tail.

Complexity: O(1) amortised time per call and O(w) space for the requests inside the
window.

Known gaps in the current implementation:

- Only one expired timestamp is dropped per call, not all of them, so the window can stay
  over-full after a burst. The eviction needs a `while` loop, not an `if`.
- The `sendingTimeMs` parameter is ignored — `System.currentTimeMillis()` is used instead,
  so the limiter cannot be tested deterministically or replayed.
- The limits are instance fields with no constructor, so they cannot be configured.
