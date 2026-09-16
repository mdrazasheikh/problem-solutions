---
title: Valid Parentheses
slug: valid-parentheses
tags: [stack, string]
aliases: [balanced brackets, matching parentheses, leetcode 20]
time: O(n)
space: O(n)
---

# Valid Parentheses

Checks whether brackets are balanced and correctly nested.

Approach: push opening brackets onto a stack and match each closing bracket against the
top of the stack.

Complexity: O(n) time and O(n) space.

Known gap: the closing-to-opening map is written

```kotlin
val map = mapOf(')' to '(', '}' to '}', ']' to ']')
```

`'}'` and `']'` map to themselves instead of to `'{'` and `'['`. Two things follow. An
opening `'{'` is in neither `map.values` nor `map.keys`, so it is dropped rather than
pushed; and a closing `'}'` *is* in `map.values`, so the `char in map.values` branch runs
first and pushes it. `isValidString("{}")` and `isValidString("[]")` both return `false`.
Only round parentheses work. The Java version in
[validparenthesis](../../java/validparenthesis) has the correct mapping.
