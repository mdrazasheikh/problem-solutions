### Longest Substring Without Repeating Characters

Difficulty: 🟢 Easy-Medium
Concepts: Sliding window, hash set, string manipulation

🧠 Prompt:
Given a string s, return the length of the longest substring without repeating characters.

💬 Intercom-style expectation:
Explain trade-offs between using a hash set vs. map, and discuss O(n) time complexity.

### Spiral Order Traversal of a Matrix

Difficulty: 🟢 Medium
Concepts: 2D array traversal, simulation, boundaries

🧠 Prompt:
Given an m x n matrix, return all elements of the matrix in spiral order.

💬 Expectation:
Talk through the iteration boundaries clearly and verify with a small example.

### Agent Assignment Scheduler

Difficulty: 🟠 Medium
Concepts: Hash map, priority queue, simulation

🧠 Prompt:
You have N agents and a stream of incoming tasks.
Each agent can handle one task at a time.
If all agents are busy, remove the agent who’s been working the longest and assign them the new task.
Return the final list of agent-to-task assignments.

💬 Expectation:
Efficient use of data structures (heapq/PriorityQueue) and clear reasoning about time complexity.

### Check if a Graph is a Tree

Difficulty: 🟠 Medium
Concepts: Graph traversal, cycle detection, DFS/BFS

🧠 Prompt:
Given an undirected graph with n nodes labeled 0...n-1, determine if it forms a valid tree.

💬 Expectation:
Explain how connectivity and cycle detection work; justify your approach.

### Edit Distance (Levenshtein Distance)

Difficulty: 🔵 Medium-Hard
Concepts: Dynamic programming, 2D DP array

🧠 Prompt:
Given two strings word1 and word2, find the minimum number of operations (insert, delete, replace) required to convert one into the other.

💬 Expectation:
Build your solution iteratively and explain memory trade-offs (O(n²) → O(n)).

### Invert a Binary Tree

Difficulty: 🟢 Medium
Concepts: Recursion, tree traversal

🧠 Prompt:
Given the root of a binary tree, invert it (mirror over its vertical axis).

💬 Expectation:
They look for clean, recursive code and mention of stack depth and iterative alternatives.

### Conversation Insights Feature (Mini-Com-style)

Difficulty: 🔵 Hard (practical coding / reasoning)
Concepts: JSON parsing, aggregation, clean code

🧠 Prompt:
You receive a JSON array of messages in an Intercom conversation:

[
{"author": "agent", "text": "Hello! How can I help you?"},
{"author": "user", "text": "Hi, I'm having trouble logging in."},
{"author": "agent", "text": "Can you try resetting your password?"}
]


Write a function to:

Count total messages from each author.

Compute the average user message length (number of words).

Return results as a summary object.

💬 Expectation:
Show structured code, small helper functions, and talk about extending it (e.g., “what if messages include attachments?”).