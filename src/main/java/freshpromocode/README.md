---
title: Fresh Promo Code
slug: fresh-promo-code
tags: [string, regex, pattern-matching]
aliases: [contiguous group match in a cart, ordered group scan]
time: O(n) expected
space: O(n)
---

# Fresh Promo Code

Checks whether a sequence of code groups appears contiguously in a shopping cart, where
the literal `anything` in a group matches any single item.

Approach: join both the code list and the cart into space-separated strings, turn the code
string into a regular expression by replacing `anything` with `\w+` and wrapping it in
`.*`, then test the cart string against it.

Complexity: O(n) expected time for the match, and O(n) space for the two joined strings
and the compiled pattern — not the O(1) a hand-rolled scan would use. The pattern is
rebuilt on every call rather than compiled once.

Known gaps:

- Matching is done on a flat string, so a group can match across an item boundary or
  inside a longer item name. Anchoring each group on whitespace would fix it.
- Items are interpolated into a regex without escaping, so an item containing regex
  metacharacters changes the meaning of the pattern.
