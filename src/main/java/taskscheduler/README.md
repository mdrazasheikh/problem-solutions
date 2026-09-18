---
title: Task Scheduler
slug: task-scheduler
leetcode: 621
difficulty: Medium
pattern: greedy
tags: [greedy, math, counting, array, scheduling]
aliases: [least interval, cpu task cooldown, schedule tasks with a cooldown]
time: O(t)
space: O(1)
---

# Task Scheduler

Given tasks labelled `A`-`Z` and a cooldown `n`, returns the fewest time units needed to
run them all when two runs of the *same* task must be at least `n` units apart. Idle units
count toward the total.

Approach: no schedule is actually built. Only the most frequent task can force an idle
slot, so the answer follows from counting.

```java
int calculated = (maxFreq - 1) * (n + 1) + maxFreqTasks;
return Math.max(tasks.length, calculated);
```

Lay out the most frequent task first. Its `maxFreq` runs split the timeline into
`maxFreq - 1` frames, each `n + 1` units wide — the task itself plus the cooldown after
it. After the last frame comes a tail holding one unit for every task tied at `maxFreq`,
since those must all appear in that final round; that is what `maxFreqTasks` counts.

Every other task drops into the idle units inside those frames. If there are more tasks
than idle units, the frames overflow, no idling is ever needed, and the answer is simply
`tasks.length` — which is why the result is the larger of the two. That single `max` is
what removes the need to simulate anything.

For `AAAABBCC` with `n = 2`: `A` appears 4 times, giving `(4-1) * 3 + 1 = 10`, against 8
tasks, so 10. The four `A`s alone force `A _ _ A _ _ A _ _ A`, and `B B C C` fill only
four of the six gaps.

Complexity: O(t) time for t tasks — three passes, two of them over a fixed 26 counters —
and O(1) space.

## Known gaps

- **An empty task array returns nonsense.** With no tasks, `maxFreq` is 0, so *all 26*
  counters tie with it and `maxFreqTasks` becomes 26. Confirmed by running it:
  `leastInterval(new char[]{}, 2)` returns 23 and `leastInterval(new char[]{}, 0)`
  returns 25, where both should be 0. Returning early on an empty input, or counting
  `maxFreqTasks` only when `maxFreq > 0`, settles it.

## Precondition

Labels must be uppercase `A`-`Z`, which is what LeetCode 621 guarantees. `freq[task - 'A']`
indexes straight off that assumption, so a lowercase label throws
`ArrayIndexOutOfBoundsException`.
