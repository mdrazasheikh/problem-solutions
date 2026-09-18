# Problem Solutions

Algorithm and design problems worked in **Java** and **Kotlin**. Each solution lives in
its own package next to a `README.md` explaining the approach and its complexity.

## Finding a solution

Everything below is generated — search the table with `Cmd-F` / `Ctrl-F`. Rows carry the
problem's common aliases, so searching how you *think* of a problem ("contiguous subarray
no duplicates") finds it even when the package is named something else. To browse by
technique instead, jump to [By technique](#by-technique).

From the terminal:

```
grep -ril "sliding-window" src/main/*/*/README.md   # every solution with a tag
grep -n "no duplicate" README.md                     # search titles and aliases
```

## Layout

One directory per solution, directly under the language root:

```
src/main/java/longestsubstring/
src/main/kotlin/longestSubstring/
src/main/java/validparenthesis/
```

Grouping is metadata, not directories. `pattern` is the single primary technique and
drives the [By pattern](#by-pattern) section; `tags` lists every technique a solution
touches and drives [By technique](#by-technique). A problem therefore appears under each
technique it uses without having to pick one folder to live in.

## Adding a solution

1. Create the package under `src/main/java/` or `src/main/kotlin/`.
2. Add a `README.md` beside it, starting with frontmatter:

   ```markdown
   ---
   title: Longest Unique Subarray
   slug: longest-unique-subarray
   pattern: sliding-window
   tags: [sliding-window, hashset, array]
   aliases: [longest contiguous subarray with no duplicate values]
   time: O(n)
   space: O(n)
   ---

   # Longest Unique Subarray
   ...
   ```

   Give the Java and Kotlin versions of the same problem the **same `slug`** and they
   collapse into one row with a link per language. Add `status: stub` for an unfinished
   solution.
3. Regenerate: `python3 tools/gen_index.py` (`--check` verifies it is current).

Tests for the generator: `cd tools && python3 test_gen_index.py`.

<!-- BEGIN INDEX -->

**59 problems** — 47 in Java, 15 in Kotlin, 3 solved in both.

37 are from LeetCode (13 easy, 22 medium, 2 hard); the rest come from Codility, HackerRank, interviews, or are plain algorithm implementations.

## All solutions

| Problem | LC | Difficulty | Pattern | Tags | Time | Space | Java | Kotlin |
|---|---|---|---|---|---|---|---|---|
| Add Two Numbers<br><sub>aka sum two numbers stored as linked lists</sub> | 2 | Medium | `linked-list` | `carry`, `linked-list`, `math` | `O(max(m, n))` | `O(1)` | — | [src](src/main/kotlin/addTwoNumbers) |
| Agent Assignment<br><sub>aka round robin task assignment, least recently assigned agent, task scheduling</sub> | — | — | `heap` | `design`, `hashmap`, `heap`, `priority-queue`, `simulation`, `treeset` | `O(t log a)` | `O(a + t)` | [src](src/main/java/agentassignment) | — |
| Average Waiting Time<br><sub>aka single chef restaurant queue</sub> | 1701 | Medium | `greedy` | `array`, `greedy`, `simulation` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/averageWaitingTime) |
| Binary Search<br><sub>aka search a sorted array, find target index</sub> | 704 | Easy | `binary-search` | `array`, `binary-search`, `sorted-array` | `O(log n)` | `O(1)` | [src](src/main/java/binarysearch) | — |
| Climbing Stairs<br><sub>aka staircase ways, count step combinations</sub> | 70 | Easy | `dynamic-programming` | `dynamic-programming`, `recursion`, `tabulation` | `O(n)` | `O(n)` | [src](src/main/java/staircase) | — |
| Contains Duplicate<br><sub>aka array has a repeated value, duplicate number, detect duplicates</sub> | 217 | Easy | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/duplicatenumber) | — |
| Contiguous Range Sum<br><sub>aka subset sum, find a range that adds to a target</sub> | — | — | `sliding-window` | `array`, `sliding-window`, `two-pointers` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/subsetSum) |
| Conversation Insight<br><sub>aka message counts by author, average user message length</sub> | — | — | `hashing` | `aggregation`, `hashmap`, `one-pass`, `string` | `O(m)` | `O(a)` | [src](src/main/java/conversationinsight) | — |
| Count Number of Teams<br><sub>aka increasing or decreasing triplets</sub> | 1395 | Medium | `arrays` | `array`, `brute-force`, `counting` | `O(n^2)` | `O(1)` | — | [src](src/main/kotlin/countNumberOfTeams) |
| Count of Balloon<br><sub>aka maximum number of balloons, form word from letters</sub> | 1189 | Easy | `hashing` | `counting`, `hashmap`, `string` | `O(n)` | `O(1)` | [src](src/main/java/countofballoon) | — |
| Deck of Cards<br><sub>aka model a card deck, suits and faces</sub> | — | — | `design` | `collections`, `design`, `enum`, `oop` | `O(n)` | `O(n)` | [src](src/main/java/deckofcards) | — |
| Design Search Autocomplete<br><sub>aka autocomplete system, trie suggestions</sub> | 642 | Hard | `prefix-search` | `autocomplete`, `design`, `prefix`, `string`, `trie` | `O(p + r)` | `O(n * l)` | — | [src](src/main/kotlin/searchString) |
| Discount Code<br><sub>aka valid discount coupon, reduce string by cancelling adjacent pairs</sub> | — | — | `stack` | `reduction`, `stack`, `string` | `O(n)` | `O(n)` | [src](src/main/java/discountcode) | — |
| Event Dispatcher — Live Coding Review<br><sub>aka publish subscribe, double checked locking, lapsed listener, find the bugs</sub> | — | — | `design` | `code-review`, `concurrency`, `design`, `observer`, `pub-sub`, `singleton`, `thread-safety` | `—` | `—` | [src](src/main/java/db/livecoding) | — |
| First Unique Character<br><sub>aka first non repeating character</sub> | 387 | Easy | `hashing` | `array`, `counting`, `string` | `O(n)` | `O(1)` | [src](src/main/java/firstuniquechar) | — |
| FizzBuzz<br><sub>aka fizz buzz multiples of three and five</sub> | 412 | Easy | `math` | `math`, `simulation`, `string` | `O(n)` | `O(n)` | — | [src](src/main/kotlin/fizzBuzz) |
| Fresh Promo Code<br><sub>aka contiguous group match in a cart, ordered group scan</sub> | — | — | `strings` | `pattern-matching`, `regex`, `string` | `O(n) expected` | `O(n)` | [src](src/main/java/freshpromocode) | — |
| Graph Valid Tree<br><sub>aka is this graph a tree, connected and acyclic, detect cycle undirected</sub> | 261 | Medium | `bfs` | `adjacency-list`, `bfs`, `connected-components`, `graph`, `queue` | `O(n + e)` | `O(n + e)` | [src](src/main/java/graphtree) | — |
| Group Anagrams<br><sub>aka group words with the same letters, anagram buckets</sub> | 49 | Medium | `hashing` | `hashmap`, `sorting`, `string` | `O(w * k log k)` | `O(w * k)` | [src](src/main/java/groupedanagram) | — |
| Heap Sort<br><sub>aka max heap sort, sift down</sub> | — | — | `sorting` | `heap`, `in-place`, `recursion`, `sorting` | `O(n log n)` | `O(log n)` | [src](src/main/java/heapsort) | — |
| House Robber<br><sub>aka maximum sum of non adjacent values</sub> | 198 | Medium | `dynamic-programming` | `array`, `dynamic-programming` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/houseRobber) |
| Invert Binary Tree<br><sub>aka mirror a binary tree, swap left and right children</sub> | 226 | Easy | `trees` | `binary-tree`, `dfs`, `recursion` | `O(n)` | `O(h)` | [src](src/main/java/invertbinarytree) | — |
| Kotlin Basics<br><sub>aka kotlin syntax notes, collections and loops</sub> | — | — | `sandbox` | `collections`, `language-basics`, `playground` | `—` | `—` | — | [src](src/main/kotlin/kotlinBasics) |
| Level Order Traversal ⚠️ _stub_<br><sub>aka breadth first tree traversal, print tree by levels</sub> | 102 | Medium | `bfs` | `bfs`, `binary-tree`, `queue` | `O(n)` | `O(w)` | [src](src/main/java/levelordertraversalofbinarytree) | — |
| Levenshtein Distance<br><sub>aka edit distance, minimum edits to convert one string to another</sub> | 72 | Medium | `dynamic-programming` | `2d-dp`, `dynamic-programming`, `edit-distance`, `string` | `O(mn)` | `O(mn)` | [src](src/main/java/levenshteindistance) | — |
| Link Unique Checker<br><sub>aka are two links the same, near duplicate url</sub> | — | — | `strings` | `normalization`, `string`, `substring` | `O(n^2)` | `O(n)` | [src](src/main/java/linkuniquechecker) | — |
| Longest Consecutive Sequence<br><sub>aka longest run of consecutive integers, unsorted consecutive streak</sub> | 128 | Medium | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/longestconsecutivesequence) | — |
| Longest Ideal Subsequence<br><sub>aka adjacent letters within k</sub> | 2370 | Medium | `dynamic-programming` | `alphabet`, `dynamic-programming`, `string` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/longestIdealSequence) |
| Longest Substring Without Repeating Characters<br><sub>aka longest unique substring, no repeating characters, longest substring with distinct chars</sub> | 3 | Medium | `sliding-window` | `hashmap`, `sliding-window`, `string`, `two-pointers` | `O(n)` | `O(k)` | [src](src/main/java/longestsubstring) | [src](src/main/kotlin/longestSubstring) |
| Longest Unique Subarray<br><sub>aka longest contiguous subarray with no duplicate values, longest distinct subarray</sub> | — | — | `sliding-window` | `array`, `hashmap`, `hashset`, `sliding-window`, `two-pointers` | `O(n)` | `O(n)` | [src](src/main/java/longestuniquesubarray) | — |
| LRU Cache<br><sub>aka least recently used cache, eviction policy, O(1) cache</sub> | 146 | Medium | `design` | `cache`, `design`, `doubly-linked-list`, `hashmap` | `O(1)` | `O(capacity)` | [src](src/main/java/lrucache) | — |
| Lucky Number<br><sub>aka josephus elimination, lucky number sieve</sub> | — | — | `math` | `josephus`, `math`, `recursion` | `O(log n)` | `O(log n)` | [src](src/main/java/luckynumber) | — |
| Maximum Twin Pair Sum<br><sub>aka maximum pages, twin sum of a linked list, max sum of first and last pair</sub> | 2130 | Medium | `linked-list` | `deque`, `linked-list`, `two-pointers` | `O(n)` | `O(n)` | [src](src/main/java/pagereadcounter) | — |
| Merge Intervals<br><sub>aka combine overlapping ranges, merge overlapping intervals</sub> | 56 | Medium | `intervals` | `array`, `greedy`, `intervals`, `sorting` | `O(n log n)` | `O(n)` | [src](src/main/java/mergeinterval) | — |
| Merge Sort<br><sub>aka recursive merge sort</sub> | — | — | `sorting` | `divide-and-conquer`, `recursion`, `sorting` | `O(n log n)` | `O(n)` | [src](src/main/java/mergesort) | — |
| Merge Two Sorted Lists<br><sub>aka merge two sorted linked lists</sub> | 21 | Easy | `linked-list` | `linked-list`, `merge`, `two-pointers` | `O(m + n)` | `O(1)` | — | [src](src/main/kotlin/sortedList) |
| Minimum Circular Alignment Cost<br><sub>aka minimum travel cost on a circle, align points around 360 degrees</sub> | — | — | `prefix-sum` | `circular-array`, `greedy`, `median`, `prefix-sum`, `sorting` | `O(n log n)` | `O(n)` | [src](src/main/java/angle) | — |
| Missing Dice Rolls<br><sub>aka find missing rolls for a target mean, distribute remaining total</sub> | — | — | `greedy` | `array`, `greedy`, `math` | `O(n + f)` | `O(f)` | [src](src/main/java/dice) | — |
| Missing Number<br><sub>aka find the missing value from 0 to n, sum difference</sub> | 268 | Easy | `math` | `array`, `gauss-sum`, `math` | `O(n)` | `O(1)` | [src](src/main/java/missingnumber) | — |
| Move Zeroes<br><sub>aka move zeros to the end, stable partition</sub> | 283 | Easy | `two-pointers` | `array`, `in-place`, `two-pointers` | `O(n)` | `O(1)` | [src](src/main/java/movezeros) | — |
| Multiply Without the Operator<br><sub>aka multiply two integers without multiplication, repeated addition</sub> | — | — | `math` | `math`, `recursion` | `O(|y|)` | `O(|y|)` | [src](src/main/java/multiply) | — |
| Quick Sort<br><sub>aka pivot partition sort</sub> | — | — | `sorting` | `divide-and-conquer`, `partition`, `recursion`, `sorting` | `O(n log n) avg` | `O(log n) avg` | [src](src/main/java/quicksort) | — |
| Rate Limiter — Sliding Window<br><sub>aka request throttling, sliding window counter, too many requests</sub> | — | — | `design` | `deque`, `design`, `rate-limiting`, `sliding-window` | `O(1) amortised` | `O(w)` | [src](src/main/java/ratechecker) | — |
| Reverse Number<br><sub>aka print digits in reverse, reverse an integer</sub> | — | — | `math` | `digits`, `math` | `O(d)` | `O(1)` | [src](src/main/java/reverse) | — |
| Rotate Linked List<br><sub>aka rotate a list right by k, ring and break</sub> | 61 | Medium | `linked-list` | `cycle`, `linked-list`, `two-pointers` | `O(n)` | `O(1)` | [src](src/main/java/rotatelinkedlist) | — |
| Search in Rotated Sorted Array<br><sub>aka find target in rotated array, pivoted sorted array search</sub> | 33 | Medium | `binary-search` | `array`, `binary-search`, `sorted-array` | `O(log n)` | `O(1)` | [src](src/main/java/rotatedsortedarraysearch) | — |
| Search Suggestions System<br><sub>aka suggestions per growing prefix, typeahead over a list</sub> | 1268 | Medium | `prefix-search` | `autocomplete`, `prefix`, `sorting`, `string` | `O(r log r + p * r * l)` | `O(r)` | [src](src/main/java/searchsuggestions) | — |
| Selection Sort<br><sub>aka repeatedly select the smallest</sub> | — | — | `sorting` | `in-place`, `sorting` | `O(n^2)` | `O(1)` | [src](src/main/java/selectionsort) | — |
| Shortest Path in a Grid<br><sub>aka shortest path in binary matrix, grid bfs, maze shortest path, fewest steps through a grid</sub> | — | — | `bfs` | `bfs`, `graph`, `matrix`, `queue`, `shortest-path` | `O(m * n)` | `O(m * n)` | [src](src/main/java/shortestpath) | — |
| Smallest Missing Positive Integer<br><sub>aka first missing positive, smallest positive not in array</sub> | 41 | Hard | `hashing` | `array`, `boolean-sieve`, `counting` | `O(n)` | `O(n)` | [src](src/main/java/smallestpositiveinteger) | — |
| Sort Colors<br><sub>aka dutch national flag, sort zeros ones twos</sub> | 75 | Medium | `two-pointers` | `array`, `dutch-national-flag`, `in-place`, `sorting`, `two-pointers` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/sortColors) |
| Spiral Matrix<br><sub>aka spiral order traversal, clockwise matrix walk</sub> | 54 | Medium | `arrays` | `boundaries`, `matrix`, `simulation` | `O(mn)` | `O(1)` | [src](src/main/java/spiraltraversal) | — |
| Squares of a Sorted Array<br><sub>aka sorted squares</sub> | 977 | Easy | `two-pointers` | `array`, `sorting`, `two-pointers` | `O(n)` | `O(n)` | — | [src](src/main/kotlin/squaresOfSortedArray) |
| Subarray Sum Equals K<br><sub>aka count contiguous subarrays with a target sum</sub> | 560 | Medium | `prefix-sum` | `array`, `hashmap`, `prefix-sum` | `O(n)` | `O(n)` | [src](src/main/java/subarraysum) | — |
| Task Scheduler<br><sub>aka least interval, cpu task cooldown, schedule tasks with a cooldown</sub> | 621 | Medium | `greedy` | `array`, `counting`, `greedy`, `math`, `scheduling` | `O(t)` | `O(1)` | [src](src/main/java/taskscheduler) | — |
| Top K Frequent Elements<br><sub>aka k most frequent numbers, most common elements</sub> | 347 | Medium | `heap` | `array`, `bucket-sort`, `counting`, `hashmap`, `heap`, `priority-queue` | `O(n log k)` | `O(n)` | [src](src/main/java/topkfrequency) | — |
| Two Sum<br><sub>aka two indices that add to a target, complement lookup</sub> | 1 | Easy | `hashing` | `array`, `hashmap` | `O(n)` | `O(n)` | [src](src/main/java/twosum) | [src](src/main/kotlin/twoSums) |
| Two Sum — Exists<br><sub>aka does an array contain two values summing to a target, pair with target sum</sub> | — | — | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/sumoftwovalues) | — |
| Valid Parentheses<br><sub>aka balanced brackets, matching parentheses</sub> | 20 | Easy | `stack` | `stack`, `string` | `O(n)` | `O(n)` | [src](src/main/java/validparenthesis) | [src](src/main/kotlin/validParenthesis) |

## By pattern

The primary technique each problem drills. Most problems use more than one, so this is a single best answer rather than the whole story; see [By technique](#by-technique) for every technique a solution touches.

### arrays (2)

- Count Number of Teams [k](src/main/kotlin/countNumberOfTeams)
- Spiral Matrix [j](src/main/java/spiraltraversal)

### bfs (3)

- Graph Valid Tree [j](src/main/java/graphtree)
- Level Order Traversal [j](src/main/java/levelordertraversalofbinarytree)
- Shortest Path in a Grid [j](src/main/java/shortestpath)

### binary-search (2)

- Binary Search [j](src/main/java/binarysearch)
- Search in Rotated Sorted Array [j](src/main/java/rotatedsortedarraysearch)

### design (4)

- Deck of Cards [j](src/main/java/deckofcards)
- Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- LRU Cache [j](src/main/java/lrucache)
- Rate Limiter — Sliding Window [j](src/main/java/ratechecker)

### dynamic-programming (4)

- Climbing Stairs [j](src/main/java/staircase)
- House Robber [k](src/main/kotlin/houseRobber)
- Levenshtein Distance [j](src/main/java/levenshteindistance)
- Longest Ideal Subsequence [k](src/main/kotlin/longestIdealSequence)

### greedy (3)

- Average Waiting Time [k](src/main/kotlin/averageWaitingTime)
- Missing Dice Rolls [j](src/main/java/dice)
- Task Scheduler [j](src/main/java/taskscheduler)

### hashing (9)

- Contains Duplicate [j](src/main/java/duplicatenumber)
- Conversation Insight [j](src/main/java/conversationinsight)
- Count of Balloon [j](src/main/java/countofballoon)
- First Unique Character [j](src/main/java/firstuniquechar)
- Group Anagrams [j](src/main/java/groupedanagram)
- Longest Consecutive Sequence [j](src/main/java/longestconsecutivesequence)
- Smallest Missing Positive Integer [j](src/main/java/smallestpositiveinteger)
- Two Sum [j](src/main/java/twosum) [k](src/main/kotlin/twoSums)
- Two Sum — Exists [j](src/main/java/sumoftwovalues)

### heap (2)

- Agent Assignment [j](src/main/java/agentassignment)
- Top K Frequent Elements [j](src/main/java/topkfrequency)

### intervals (1)

- Merge Intervals [j](src/main/java/mergeinterval)

### linked-list (4)

- Add Two Numbers [k](src/main/kotlin/addTwoNumbers)
- Maximum Twin Pair Sum [j](src/main/java/pagereadcounter)
- Merge Two Sorted Lists [k](src/main/kotlin/sortedList)
- Rotate Linked List [j](src/main/java/rotatelinkedlist)

### math (5)

- FizzBuzz [k](src/main/kotlin/fizzBuzz)
- Lucky Number [j](src/main/java/luckynumber)
- Missing Number [j](src/main/java/missingnumber)
- Multiply Without the Operator [j](src/main/java/multiply)
- Reverse Number [j](src/main/java/reverse)

### prefix-search (2)

- Design Search Autocomplete [k](src/main/kotlin/searchString)
- Search Suggestions System [j](src/main/java/searchsuggestions)

### prefix-sum (2)

- Minimum Circular Alignment Cost [j](src/main/java/angle)
- Subarray Sum Equals K [j](src/main/java/subarraysum)

### sandbox (1)

- Kotlin Basics [k](src/main/kotlin/kotlinBasics)

### sliding-window (3)

- Contiguous Range Sum [k](src/main/kotlin/subsetSum)
- Longest Substring Without Repeating Characters [j](src/main/java/longestsubstring) [k](src/main/kotlin/longestSubstring)
- Longest Unique Subarray [j](src/main/java/longestuniquesubarray)

### sorting (4)

- Heap Sort [j](src/main/java/heapsort)
- Merge Sort [j](src/main/java/mergesort)
- Quick Sort [j](src/main/java/quicksort)
- Selection Sort [j](src/main/java/selectionsort)

### stack (2)

- Discount Code [j](src/main/java/discountcode)
- Valid Parentheses [j](src/main/java/validparenthesis) [k](src/main/kotlin/validParenthesis)

### strings (2)

- Fresh Promo Code [j](src/main/java/freshpromocode)
- Link Unique Checker [j](src/main/java/linkuniquechecker)

### trees (1)

- Invert Binary Tree [j](src/main/java/invertbinarytree)

### two-pointers (3)

- Move Zeroes [j](src/main/java/movezeros)
- Sort Colors [k](src/main/kotlin/sortColors)
- Squares of a Sorted Array [k](src/main/kotlin/squaresOfSortedArray)

## By technique

- **`2d-dp`** — Levenshtein Distance [j](src/main/java/levenshteindistance)
- **`adjacency-list`** — Graph Valid Tree [j](src/main/java/graphtree)
- **`aggregation`** — Conversation Insight [j](src/main/java/conversationinsight)
- **`alphabet`** — Longest Ideal Subsequence [k](src/main/kotlin/longestIdealSequence)
- **`array`** — Average Waiting Time [k](src/main/kotlin/averageWaitingTime), Binary Search [j](src/main/java/binarysearch), Contains Duplicate [j](src/main/java/duplicatenumber), Contiguous Range Sum [k](src/main/kotlin/subsetSum), Count Number of Teams [k](src/main/kotlin/countNumberOfTeams), First Unique Character [j](src/main/java/firstuniquechar), House Robber [k](src/main/kotlin/houseRobber), Longest Consecutive Sequence [j](src/main/java/longestconsecutivesequence), Longest Unique Subarray [j](src/main/java/longestuniquesubarray), Merge Intervals [j](src/main/java/mergeinterval), Missing Dice Rolls [j](src/main/java/dice), Missing Number [j](src/main/java/missingnumber), Move Zeroes [j](src/main/java/movezeros), Search in Rotated Sorted Array [j](src/main/java/rotatedsortedarraysearch), Smallest Missing Positive Integer [j](src/main/java/smallestpositiveinteger), Sort Colors [k](src/main/kotlin/sortColors), Squares of a Sorted Array [k](src/main/kotlin/squaresOfSortedArray), Subarray Sum Equals K [j](src/main/java/subarraysum), Task Scheduler [j](src/main/java/taskscheduler), Top K Frequent Elements [j](src/main/java/topkfrequency), Two Sum [j](src/main/java/twosum) [k](src/main/kotlin/twoSums), Two Sum — Exists [j](src/main/java/sumoftwovalues)
- **`autocomplete`** — Design Search Autocomplete [k](src/main/kotlin/searchString), Search Suggestions System [j](src/main/java/searchsuggestions)
- **`bfs`** — Graph Valid Tree [j](src/main/java/graphtree), Level Order Traversal [j](src/main/java/levelordertraversalofbinarytree), Shortest Path in a Grid [j](src/main/java/shortestpath)
- **`binary-search`** — Binary Search [j](src/main/java/binarysearch), Search in Rotated Sorted Array [j](src/main/java/rotatedsortedarraysearch)
- **`binary-tree`** — Invert Binary Tree [j](src/main/java/invertbinarytree), Level Order Traversal [j](src/main/java/levelordertraversalofbinarytree)
- **`boolean-sieve`** — Smallest Missing Positive Integer [j](src/main/java/smallestpositiveinteger)
- **`boundaries`** — Spiral Matrix [j](src/main/java/spiraltraversal)
- **`brute-force`** — Count Number of Teams [k](src/main/kotlin/countNumberOfTeams)
- **`bucket-sort`** — Top K Frequent Elements [j](src/main/java/topkfrequency)
- **`cache`** — LRU Cache [j](src/main/java/lrucache)
- **`carry`** — Add Two Numbers [k](src/main/kotlin/addTwoNumbers)
- **`circular-array`** — Minimum Circular Alignment Cost [j](src/main/java/angle)
- **`code-review`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`collections`** — Deck of Cards [j](src/main/java/deckofcards), Kotlin Basics [k](src/main/kotlin/kotlinBasics)
- **`concurrency`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`connected-components`** — Graph Valid Tree [j](src/main/java/graphtree)
- **`counting`** — Count Number of Teams [k](src/main/kotlin/countNumberOfTeams), Count of Balloon [j](src/main/java/countofballoon), First Unique Character [j](src/main/java/firstuniquechar), Smallest Missing Positive Integer [j](src/main/java/smallestpositiveinteger), Task Scheduler [j](src/main/java/taskscheduler), Top K Frequent Elements [j](src/main/java/topkfrequency)
- **`cycle`** — Rotate Linked List [j](src/main/java/rotatelinkedlist)
- **`deque`** — Maximum Twin Pair Sum [j](src/main/java/pagereadcounter), Rate Limiter — Sliding Window [j](src/main/java/ratechecker)
- **`design`** — Agent Assignment [j](src/main/java/agentassignment), Deck of Cards [j](src/main/java/deckofcards), Design Search Autocomplete [k](src/main/kotlin/searchString), Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding), LRU Cache [j](src/main/java/lrucache), Rate Limiter — Sliding Window [j](src/main/java/ratechecker)
- **`dfs`** — Invert Binary Tree [j](src/main/java/invertbinarytree)
- **`digits`** — Reverse Number [j](src/main/java/reverse)
- **`divide-and-conquer`** — Merge Sort [j](src/main/java/mergesort), Quick Sort [j](src/main/java/quicksort)
- **`doubly-linked-list`** — LRU Cache [j](src/main/java/lrucache)
- **`dutch-national-flag`** — Sort Colors [k](src/main/kotlin/sortColors)
- **`dynamic-programming`** — Climbing Stairs [j](src/main/java/staircase), House Robber [k](src/main/kotlin/houseRobber), Levenshtein Distance [j](src/main/java/levenshteindistance), Longest Ideal Subsequence [k](src/main/kotlin/longestIdealSequence)
- **`edit-distance`** — Levenshtein Distance [j](src/main/java/levenshteindistance)
- **`enum`** — Deck of Cards [j](src/main/java/deckofcards)
- **`gauss-sum`** — Missing Number [j](src/main/java/missingnumber)
- **`graph`** — Graph Valid Tree [j](src/main/java/graphtree), Shortest Path in a Grid [j](src/main/java/shortestpath)
- **`greedy`** — Average Waiting Time [k](src/main/kotlin/averageWaitingTime), Merge Intervals [j](src/main/java/mergeinterval), Minimum Circular Alignment Cost [j](src/main/java/angle), Missing Dice Rolls [j](src/main/java/dice), Task Scheduler [j](src/main/java/taskscheduler)
- **`hashmap`** — Agent Assignment [j](src/main/java/agentassignment), Conversation Insight [j](src/main/java/conversationinsight), Count of Balloon [j](src/main/java/countofballoon), Group Anagrams [j](src/main/java/groupedanagram), Longest Substring Without Repeating Characters [j](src/main/java/longestsubstring) [k](src/main/kotlin/longestSubstring), Longest Unique Subarray [j](src/main/java/longestuniquesubarray), LRU Cache [j](src/main/java/lrucache), Subarray Sum Equals K [j](src/main/java/subarraysum), Top K Frequent Elements [j](src/main/java/topkfrequency), Two Sum [j](src/main/java/twosum) [k](src/main/kotlin/twoSums)
- **`hashset`** — Contains Duplicate [j](src/main/java/duplicatenumber), Longest Consecutive Sequence [j](src/main/java/longestconsecutivesequence), Longest Unique Subarray [j](src/main/java/longestuniquesubarray), Two Sum — Exists [j](src/main/java/sumoftwovalues)
- **`heap`** — Agent Assignment [j](src/main/java/agentassignment), Heap Sort [j](src/main/java/heapsort), Top K Frequent Elements [j](src/main/java/topkfrequency)
- **`in-place`** — Heap Sort [j](src/main/java/heapsort), Move Zeroes [j](src/main/java/movezeros), Selection Sort [j](src/main/java/selectionsort), Sort Colors [k](src/main/kotlin/sortColors)
- **`intervals`** — Merge Intervals [j](src/main/java/mergeinterval)
- **`josephus`** — Lucky Number [j](src/main/java/luckynumber)
- **`language-basics`** — Kotlin Basics [k](src/main/kotlin/kotlinBasics)
- **`linked-list`** — Add Two Numbers [k](src/main/kotlin/addTwoNumbers), Maximum Twin Pair Sum [j](src/main/java/pagereadcounter), Merge Two Sorted Lists [k](src/main/kotlin/sortedList), Rotate Linked List [j](src/main/java/rotatelinkedlist)
- **`math`** — Add Two Numbers [k](src/main/kotlin/addTwoNumbers), FizzBuzz [k](src/main/kotlin/fizzBuzz), Lucky Number [j](src/main/java/luckynumber), Missing Dice Rolls [j](src/main/java/dice), Missing Number [j](src/main/java/missingnumber), Multiply Without the Operator [j](src/main/java/multiply), Reverse Number [j](src/main/java/reverse), Task Scheduler [j](src/main/java/taskscheduler)
- **`matrix`** — Shortest Path in a Grid [j](src/main/java/shortestpath), Spiral Matrix [j](src/main/java/spiraltraversal)
- **`median`** — Minimum Circular Alignment Cost [j](src/main/java/angle)
- **`merge`** — Merge Two Sorted Lists [k](src/main/kotlin/sortedList)
- **`normalization`** — Link Unique Checker [j](src/main/java/linkuniquechecker)
- **`observer`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`one-pass`** — Conversation Insight [j](src/main/java/conversationinsight)
- **`oop`** — Deck of Cards [j](src/main/java/deckofcards)
- **`partition`** — Quick Sort [j](src/main/java/quicksort)
- **`pattern-matching`** — Fresh Promo Code [j](src/main/java/freshpromocode)
- **`playground`** — Kotlin Basics [k](src/main/kotlin/kotlinBasics)
- **`prefix`** — Design Search Autocomplete [k](src/main/kotlin/searchString), Search Suggestions System [j](src/main/java/searchsuggestions)
- **`prefix-sum`** — Minimum Circular Alignment Cost [j](src/main/java/angle), Subarray Sum Equals K [j](src/main/java/subarraysum)
- **`priority-queue`** — Agent Assignment [j](src/main/java/agentassignment), Top K Frequent Elements [j](src/main/java/topkfrequency)
- **`pub-sub`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`queue`** — Graph Valid Tree [j](src/main/java/graphtree), Level Order Traversal [j](src/main/java/levelordertraversalofbinarytree), Shortest Path in a Grid [j](src/main/java/shortestpath)
- **`rate-limiting`** — Rate Limiter — Sliding Window [j](src/main/java/ratechecker)
- **`recursion`** — Climbing Stairs [j](src/main/java/staircase), Heap Sort [j](src/main/java/heapsort), Invert Binary Tree [j](src/main/java/invertbinarytree), Lucky Number [j](src/main/java/luckynumber), Merge Sort [j](src/main/java/mergesort), Multiply Without the Operator [j](src/main/java/multiply), Quick Sort [j](src/main/java/quicksort)
- **`reduction`** — Discount Code [j](src/main/java/discountcode)
- **`regex`** — Fresh Promo Code [j](src/main/java/freshpromocode)
- **`scheduling`** — Task Scheduler [j](src/main/java/taskscheduler)
- **`shortest-path`** — Shortest Path in a Grid [j](src/main/java/shortestpath)
- **`simulation`** — Agent Assignment [j](src/main/java/agentassignment), Average Waiting Time [k](src/main/kotlin/averageWaitingTime), FizzBuzz [k](src/main/kotlin/fizzBuzz), Spiral Matrix [j](src/main/java/spiraltraversal)
- **`singleton`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`sliding-window`** — Contiguous Range Sum [k](src/main/kotlin/subsetSum), Longest Substring Without Repeating Characters [j](src/main/java/longestsubstring) [k](src/main/kotlin/longestSubstring), Longest Unique Subarray [j](src/main/java/longestuniquesubarray), Rate Limiter — Sliding Window [j](src/main/java/ratechecker)
- **`sorted-array`** — Binary Search [j](src/main/java/binarysearch), Search in Rotated Sorted Array [j](src/main/java/rotatedsortedarraysearch)
- **`sorting`** — Group Anagrams [j](src/main/java/groupedanagram), Heap Sort [j](src/main/java/heapsort), Merge Intervals [j](src/main/java/mergeinterval), Merge Sort [j](src/main/java/mergesort), Minimum Circular Alignment Cost [j](src/main/java/angle), Quick Sort [j](src/main/java/quicksort), Search Suggestions System [j](src/main/java/searchsuggestions), Selection Sort [j](src/main/java/selectionsort), Sort Colors [k](src/main/kotlin/sortColors), Squares of a Sorted Array [k](src/main/kotlin/squaresOfSortedArray)
- **`stack`** — Discount Code [j](src/main/java/discountcode), Valid Parentheses [j](src/main/java/validparenthesis) [k](src/main/kotlin/validParenthesis)
- **`string`** — Conversation Insight [j](src/main/java/conversationinsight), Count of Balloon [j](src/main/java/countofballoon), Design Search Autocomplete [k](src/main/kotlin/searchString), Discount Code [j](src/main/java/discountcode), First Unique Character [j](src/main/java/firstuniquechar), FizzBuzz [k](src/main/kotlin/fizzBuzz), Fresh Promo Code [j](src/main/java/freshpromocode), Group Anagrams [j](src/main/java/groupedanagram), Levenshtein Distance [j](src/main/java/levenshteindistance), Link Unique Checker [j](src/main/java/linkuniquechecker), Longest Ideal Subsequence [k](src/main/kotlin/longestIdealSequence), Longest Substring Without Repeating Characters [j](src/main/java/longestsubstring) [k](src/main/kotlin/longestSubstring), Search Suggestions System [j](src/main/java/searchsuggestions), Valid Parentheses [j](src/main/java/validparenthesis) [k](src/main/kotlin/validParenthesis)
- **`substring`** — Link Unique Checker [j](src/main/java/linkuniquechecker)
- **`tabulation`** — Climbing Stairs [j](src/main/java/staircase)
- **`thread-safety`** — Event Dispatcher — Live Coding Review [j](src/main/java/db/livecoding)
- **`treeset`** — Agent Assignment [j](src/main/java/agentassignment)
- **`trie`** — Design Search Autocomplete [k](src/main/kotlin/searchString)
- **`two-pointers`** — Contiguous Range Sum [k](src/main/kotlin/subsetSum), Longest Substring Without Repeating Characters [j](src/main/java/longestsubstring) [k](src/main/kotlin/longestSubstring), Longest Unique Subarray [j](src/main/java/longestuniquesubarray), Maximum Twin Pair Sum [j](src/main/java/pagereadcounter), Merge Two Sorted Lists [k](src/main/kotlin/sortedList), Move Zeroes [j](src/main/java/movezeros), Rotate Linked List [j](src/main/java/rotatelinkedlist), Sort Colors [k](src/main/kotlin/sortColors), Squares of a Sorted Array [k](src/main/kotlin/squaresOfSortedArray)

<!-- END INDEX -->
