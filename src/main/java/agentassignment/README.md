---
title: Agent Assignment
slug: agent-assignment
tags: [simulation, priority-queue, heap, treeset, hashmap, design]
aliases: [round robin task assignment, least recently assigned agent, task scheduling]
time: O(t log a)
space: O(a + t)
---

# Agent Assignment

Assigns tasks to agents while tracking the current assignment for each agent.

Approach: simulate assignments with maps and a priority queue for availability.

Complexity: O(t log a) time and O(a + t) space for t tasks and a agents.
