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

Approach: keep the timestamps of accepted requests in a deque. On each call, drop every
timestamp that has fallen out of the window, reject if the remaining count is at the cap,
and otherwise record the new timestamp at the tail. Rejected requests are not recorded, so
being throttled never extends how long the caller stays throttled.

Complexity: O(1) amortised time per call — each timestamp is added and removed at most
once — and O(w) space for the requests inside the window.

## Design notes

- **The caller supplies the clock.** `checkRequest(long sendingTimeMs)` uses its argument
  rather than `System.currentTimeMillis()`, which is what makes the behaviour testable and
  replayable. Timestamps must be non-decreasing; a backwards jump throws
  `IllegalArgumentException` rather than silently corrupting the deque's ordering.
- **The window is half-open.** A request at `t` counts the requests in `(t - window, t]`,
  so an entry exactly one window old has already left.
- **Limits are constructor arguments**, so one limiter can be 5 requests per second and
  another 1000 per two seconds. The no-arg constructor keeps the original 1000-per-2s
  default.
- **`synchronized`**, because a limiter is normally shared across request threads.

Tests: `src/test/java/ratechecker/RateCheckerTest.java` — run with `./gradlew test`.
