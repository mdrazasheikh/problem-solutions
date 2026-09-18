---
title: Valid Parentheses
slug: valid-parentheses
leetcode: 20
difficulty: Easy
pattern: stack
tags: [stack, string]
aliases: [balanced brackets, matching parentheses]
time: O(n)
space: O(n)
---

# Valid Parentheses

Checks whether brackets are balanced and correctly nested.

Approach: push opening brackets onto a stack; on a closing bracket, pop and compare
against the opening it should match. The string is valid when every closing bracket found
its partner and the stack ends empty. Characters that are not brackets are ignored.

Complexity: O(n) time and O(n) space.

Tests: `src/test/kotlin/validparenthesis/ValidParenthesisTest.kt`.
