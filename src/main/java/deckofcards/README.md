---
title: Deck of Cards
slug: deck-of-cards
tags: [design, enum, oop, collections]
aliases: [model a card deck, suits and faces]
time: O(n)
space: O(n)
---

# Deck Of Cards

Models cards, suits, faces, and deck creation using Java enums and collections.

Approach: `Face` and `Suit` are enums carrying an explicit rank and order, and the deck is
built by taking the product of the two, wrapped in a `List` and shuffled.

Complexity: deck creation is O(n) time, including the shuffle, and O(n) space for n cards.
