---
title: Event Dispatcher — Live Coding Review
slug: event-dispatcher-review
pattern: design
tags: [concurrency, design, singleton, pub-sub, code-review, thread-safety, observer]
aliases: [publish subscribe, double checked locking, lapsed listener, find the bugs]
---

# Event Dispatcher — Live Coding Review

A pub/sub dispatcher handed over as a code-review exercise: find the bugs, the
implementation risks, and what it would take to ship it.

`Problem.java` is the original, kept verbatim with the review written inline as comments.
It does not compile — two of the findings are the compile errors themselves — so it is
excluded from the build in `build.gradle.kts`.

`Solution.java` is the fixed version. Run it to see all three demos pass.

## Findings

| # | Severity | Finding |
|---|----------|---------|
| 1 | Compile error | `new Event(new Object())` — the only constructor takes `Map<String, Double>` |
| 2 | Compile error | `@Test` is not imported, and the project declares no test dependency |
| 3 | Bug | Broken double-checked locking: null check outside the lock, none inside, so two dispatchers can be built and one is silently discarded |
| 4 | Concurrency | `instance` is not `volatile` — no safe publication |
| 5 | Concurrency | Plain `ArrayList` registry written and iterated concurrently → `ConcurrentModificationException` |
| 6 | Bug | A listener that throws aborts the dispatch loop; the rest never get the event |
| 7 | Bug | Test asserts nothing and never joins — it passes even if zero events are delivered |
| 8 | Bug | Start-order race: the publisher can fire all 100 events before the subscriber registers |
| 9 | Bug | `Event` has no `toString`, so the log line prints `MyCode$Event@1b6d3586` |
| 10 | Bug | `Event` takes no defensive copy and leaks its internal map through the getter |
| 11 | Bug | The `setPayload` setter makes a broadcast event mutable — two listeners can observe different payloads for the same event |
| 12 | Design | No `unregisterListener`, on a process-lifetime singleton → lapsed-listener leak |
| 13 | Design | Global mutable singleton cannot be reset, mocked, or injected |
| 14 | Design | `extends Thread` conflates subscriber identity with scheduling; the thread makes one non-blocking call and dies |
| 15 | Design | Synchronous dispatch on the publisher's thread, no backpressure or timeout |
| 16 | Production | `System.out` instead of a logger; test scaffolding shipping in `src/main/java`; no null or duplicate validation |

## What the fix changes

`Solution.java` keeps the structure of the original — the same nested `EventDispatcher`,
`EventListener`, `Event` and `PubSubTest` types, and the same `getInstance`,
`registerListener`, `fireEvent`, `getPayload` and `test` names — so the two files can be
read side by side. Every change sits at the site of the finding it answers, marked `FIX`.

| Site | Change |
|------|--------|
| `instance` | `volatile`, so the reference is safely published |
| `getInstance` | Real double-checked locking: the null check is repeated inside the lock |
| `listeners` | `final CopyOnWriteArrayList` — dispatch iterates a snapshot, so registering mid-dispatch is safe |
| `registerListener` | Rejects null at the call site actually at fault |
| `unregisterListener` | Added — closes the lapsed-listener leak |
| `fireEvent` | Null check, and each delivery wrapped so one throwing listener no longer starves the rest |
| `Event` | Final field, defensive `Map.copyOf`, setter removed, `toString`/`equals`/`hashCode` added |
| `Subscriber` | `implements Runnable` instead of `extends Thread`; counts what it receives |
| `Publisher` | Waits on a latch before publishing, and constructs a valid `Event` (the original did not compile) |
| `test` | `ExecutorService` + `awaitTermination`, then checks the delivery count |

The singleton is deliberately kept rather than replaced with dependency injection: the
point is to show the locking fixed. Injection is still the better design, and the
`Event` class is written longhand only to preserve the original `getPayload()` API — in
Java 21 it is one line as a `record`.

Run it:

```
java --enable-preview -cp build/classes/java/main db.livecoding.Solution
```

```
published  : 100
deliveries : 300 (expected 300)
result     : PASS

survived a throwing listener : true
payload unmodifiable         : true
event toString               : Event{price=42.5}
```
