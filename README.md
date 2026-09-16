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

Solutions are filed by the pattern they teach, not alphabetically:

```
src/main/java/slidingwindow/longestsubstring/
src/main/kotlin/slidingwindow/longestSubstring/
src/main/java/stack/validparenthesis/
```

Bucket directories double as Java package names, so they carry no hyphen
(`slidingwindow`, not `sliding-window`) even though the index prints the readable form.
Kotlin package declarations do not have to track directories and are left as they are.

A problem usually uses more than one technique. `pattern` is the primary one and decides
the directory; `tags` lists every technique it touches and drives the
[By technique](#by-technique) section, so a problem stays findable under all of them.

## Adding a solution

1. Create the package under the right pattern bucket.
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

**55 problems** — 43 in Java, 15 in Kotlin, 3 solved in both.

## All solutions

| Problem | Pattern | Tags | Time | Space | Java | Kotlin |
|---|---|---|---|---|---|---|
| Add Two Numbers<br><sub>aka sum two numbers stored as linked lists, leetcode 2</sub> | `linked-list` | `carry`, `linked-list`, `math` | `O(max(m, n))` | `O(1)` | — | [src](src/main/kotlin/linkedlist/addTwoNumbers) |
| Agent Assignment<br><sub>aka round robin task assignment, least recently assigned agent, task scheduling</sub> | `heap` | `design`, `hashmap`, `heap`, `priority-queue`, `simulation`, `treeset` | `O(t log a)` | `O(a + t)` | [src](src/main/java/heap/agentassignment) | — |
| Average Waiting Time<br><sub>aka leetcode 1701, single chef restaurant queue</sub> | `greedy` | `array`, `greedy`, `simulation` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/greedy/averageWaitingTime) |
| Binary Search<br><sub>aka search a sorted array, find target index</sub> | `binary-search` | `array`, `binary-search`, `sorted-array` | `O(log n)` | `O(1)` | [src](src/main/java/binarysearch/binarysearch) | — |
| Climbing Stairs<br><sub>aka staircase ways, count step combinations</sub> | `dynamic-programming` | `dynamic-programming`, `memoization`, `recursion` | `O(n)` | `O(n)` | [src](src/main/java/dynamicprogramming/staircase) | — |
| Contains Duplicate<br><sub>aka array has a repeated value, duplicate number, detect duplicates</sub> | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/hashing/duplicatenumber) | — |
| Contiguous Range Sum<br><sub>aka subset sum, find a range that adds to a target</sub> | `sliding-window` | `array`, `sliding-window`, `two-pointer` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/slidingwindow/subsetSum) |
| Conversation Insight<br><sub>aka message counts by author, average user message length</sub> | `hashing` | `aggregation`, `hashmap`, `one-pass`, `string` | `O(m)` | `O(a)` | [src](src/main/java/hashing/conversationinsight) | — |
| Count Number of Teams<br><sub>aka leetcode 1395, increasing or decreasing triplets</sub> | `arrays` | `array`, `brute-force`, `counting` | `O(n^2)` | `O(1)` | — | [src](src/main/kotlin/arrays/countNumberOfTeams) |
| Count of Balloon<br><sub>aka maximum number of balloons, form word from letters</sub> | `hashing` | `counting`, `hashmap`, `string` | `O(n)` | `O(1)` | [src](src/main/java/hashing/countofballoon) | — |
| Deck of Cards<br><sub>aka model a card deck, suits and faces</sub> | `design` | `collections`, `design`, `enum`, `oop` | `O(n)` | `O(n)` | [src](src/main/java/design/deckofcards) | — |
| Design Search Autocomplete<br><sub>aka leetcode 642, autocomplete system, trie suggestions</sub> | `prefix-search` | `autocomplete`, `design`, `prefix`, `string`, `trie` | `O(p + r)` | `O(n * l)` | — | [src](src/main/kotlin/prefixsearch/searchString) |
| Discount Code<br><sub>aka valid discount coupon, reduce string by cancelling adjacent pairs</sub> | `stack` | `reduction`, `stack`, `string` | `O(n)` | `O(n)` | [src](src/main/java/stack/discountcode) | — |
| Event Dispatcher — Live Coding Review<br><sub>aka publish subscribe, double checked locking, lapsed listener, find the bugs</sub> | `design` | `code-review`, `concurrency`, `design`, `observer`, `pub-sub`, `singleton`, `thread-safety` | `—` | `—` | [src](src/main/java/design/db/livecoding) | — |
| First Unique Character<br><sub>aka first non repeating character</sub> | `hashing` | `counting`, `hashmap`, `string` | `O(n)` | `O(1)` | [src](src/main/java/hashing/firstuniquechar) | — |
| FizzBuzz<br><sub>aka fizz buzz multiples of three and five</sub> | `math` | `math`, `simulation`, `string` | `O(n)` | `O(n)` | — | [src](src/main/kotlin/math/fizzBuzz) |
| Fresh Promo Code<br><sub>aka contiguous group match in a cart, ordered group scan</sub> | `strings` | `pattern-matching`, `regex`, `string` | `O(n) expected` | `O(n)` | [src](src/main/java/strings/freshpromocode) | — |
| Graph Valid Tree<br><sub>aka is this graph a tree, connected and acyclic, detect cycle undirected</sub> | `bfs` | `adjacency-list`, `bfs`, `connected-components`, `graph`, `queue` | `O(n + e)` | `O(n + e)` | [src](src/main/java/bfs/graphtree) | — |
| Group Anagrams<br><sub>aka group words with the same letters, anagram buckets</sub> | `hashing` | `hashmap`, `sorting`, `string` | `O(w * k log k)` | `O(w * k)` | [src](src/main/java/hashing/groupedanagram) | — |
| Heap Sort<br><sub>aka max heap sort, sift down</sub> | `sorting` | `heap`, `in-place`, `sorting` | `O(n log n)` | `O(log n)` | [src](src/main/java/sorting/heapsort) | — |
| House Robber<br><sub>aka leetcode 198, maximum sum of non adjacent values</sub> | `dynamic-programming` | `array`, `dynamic-programming` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/dynamicprogramming/houseRobber) |
| Invert Binary Tree<br><sub>aka mirror a binary tree, swap left and right children</sub> | `trees` | `binary-tree`, `dfs`, `recursion` | `O(n)` | `O(h)` | [src](src/main/java/trees/invertbinarytree) | — |
| Kotlin Basics<br><sub>aka kotlin syntax notes, collections and loops</sub> | `sandbox` | `collections`, `language-basics`, `playground` | `—` | `—` | — | [src](src/main/kotlin/sandbox/kotlinBasics) |
| Level Order Traversal ⚠️ _stub_<br><sub>aka breadth first tree traversal, print tree by levels</sub> | `bfs` | `bfs`, `binary-tree`, `queue` | `O(n)` | `O(w)` | [src](src/main/java/bfs/levelordertraversalofbinarytree) | — |
| Levenshtein Distance<br><sub>aka edit distance, minimum edits to convert one string to another</sub> | `dynamic-programming` | `2d-dp`, `dynamic-programming`, `edit-distance`, `string` | `O(mn)` | `O(mn)` | [src](src/main/java/dynamicprogramming/levenshteindistance) | — |
| Link Unique Checker<br><sub>aka are two links the same, near duplicate url</sub> | `strings` | `normalization`, `string`, `substring` | `O(n^2)` | `O(n)` | [src](src/main/java/strings/linkuniquechecker) | — |
| Longest Consecutive Sequence<br><sub>aka longest run of consecutive integers, unsorted consecutive streak</sub> | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/hashing/longestconsecutivesequence) | — |
| Longest Ideal Subsequence<br><sub>aka leetcode 2370, adjacent letters within k</sub> | `dynamic-programming` | `alphabet`, `dynamic-programming`, `string` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/dynamicprogramming/longestIdealSequence) |
| Longest Substring Without Repeating Characters<br><sub>aka longest unique substring, no repeating characters, longest substring with distinct chars</sub> | `sliding-window` | `hashmap`, `sliding-window`, `string`, `two-pointer` | `O(n)` | `O(k)` | [src](src/main/java/slidingwindow/longestsubstring) | [src](src/main/kotlin/slidingwindow/longestSubstring) |
| Longest Unique Subarray<br><sub>aka longest contiguous subarray with no duplicate values, longest distinct subarray</sub> | `sliding-window` | `array`, `hashmap`, `hashset`, `sliding-window`, `two-pointer` | `O(n)` | `O(n)` | [src](src/main/java/slidingwindow/longestuniquesubarray) | — |
| LRU Cache<br><sub>aka least recently used cache, eviction policy, O(1) cache</sub> | `design` | `cache`, `design`, `doubly-linked-list`, `hashmap` | `O(1)` | `O(capacity)` | [src](src/main/java/design/lrucache) | — |
| Lucky Number<br><sub>aka josephus elimination, lucky number sieve</sub> | `math` | `josephus`, `math`, `recursion` | `O(log n)` | `O(log n)` | [src](src/main/java/math/luckynumber) | — |
| Maximum Twin Pair Sum<br><sub>aka maximum pages, twin sum of a linked list, max sum of first and last pair</sub> | `linked-list` | `deque`, `linked-list`, `two-pointer` | `O(n)` | `O(n)` | [src](src/main/java/linkedlist/pagereadcounter) | — |
| Merge Sort<br><sub>aka recursive merge sort</sub> | `sorting` | `divide-and-conquer`, `recursion`, `sorting` | `O(n log n)` | `O(n)` | [src](src/main/java/sorting/mergesort) | — |
| Merge Two Sorted Lists<br><sub>aka merge two sorted linked lists, leetcode 21</sub> | `linked-list` | `linked-list`, `merge`, `two-pointer` | `O(m + n)` | `O(1)` | — | [src](src/main/kotlin/linkedlist/sortedList) |
| Minimum Circular Alignment Cost<br><sub>aka minimum travel cost on a circle, align points around 360 degrees</sub> | `prefix-sum` | `circular-array`, `greedy`, `median`, `prefix-sum`, `sorting` | `O(n log n)` | `O(n)` | [src](src/main/java/prefixsum/angle) | — |
| Missing Dice Rolls<br><sub>aka find missing rolls for a target mean, distribute remaining total</sub> | `greedy` | `array`, `greedy`, `math` | `O(n + f)` | `O(f)` | [src](src/main/java/greedy/dice) | — |
| Missing Number<br><sub>aka find the missing value from 0 to n, sum difference</sub> | `math` | `array`, `gauss-sum`, `math` | `O(n)` | `O(1)` | [src](src/main/java/math/missingnumber) | — |
| Move Zeroes<br><sub>aka move zeros to the end, stable partition</sub> | `two-pointers` | `array`, `in-place`, `two-pointer` | `O(n)` | `O(1)` | [src](src/main/java/twopointers/movezeros) | — |
| Multiply Without the Operator<br><sub>aka multiply two integers without multiplication, repeated addition</sub> | `math` | `math`, `recursion` | `O(|y|)` | `O(|y|)` | [src](src/main/java/math/multiply) | — |
| Quick Sort<br><sub>aka pivot partition sort</sub> | `sorting` | `divide-and-conquer`, `partition`, `recursion`, `sorting` | `O(n log n) avg` | `O(log n) avg` | [src](src/main/java/sorting/quicksort) | — |
| Rate Limiter — Sliding Window<br><sub>aka request throttling, sliding window counter, too many requests</sub> | `design` | `deque`, `design`, `rate-limiting`, `sliding-window` | `O(1) amortised` | `O(w)` | [src](src/main/java/design/ratechecker) | — |
| Reverse Number<br><sub>aka print digits in reverse, reverse an integer</sub> | `math` | `digits`, `math` | `O(d)` | `O(1)` | [src](src/main/java/math/reverse) | — |
| Rotate Linked List<br><sub>aka rotate a list right by k, ring and break</sub> | `linked-list` | `cycle`, `linked-list`, `two-pointer` | `O(n)` | `O(1)` | [src](src/main/java/linkedlist/rotatelinkedlist) | — |
| Search Suggestions System<br><sub>aka suggestions per growing prefix, typeahead over a list</sub> | `prefix-search` | `autocomplete`, `prefix`, `sorting`, `string` | `O(r log r + p * r * l)` | `O(r)` | [src](src/main/java/prefixsearch/searchsuggestions) | — |
| Selection Sort<br><sub>aka repeatedly select the smallest</sub> | `sorting` | `in-place`, `sorting` | `O(n^2)` | `O(1)` | [src](src/main/java/sorting/selectionsort) | — |
| Shortest Path in a Grid<br><sub>aka shortest path in binary matrix, grid bfs, maze shortest path, fewest steps through a grid</sub> | `bfs` | `bfs`, `graph`, `matrix`, `queue`, `shortest-path` | `O(m * n)` | `O(m * n)` | [src](src/main/java/bfs/shortestpath) | — |
| Smallest Missing Positive Integer<br><sub>aka first missing positive, smallest positive not in array</sub> | `hashing` | `array`, `boolean-sieve`, `counting` | `O(n)` | `O(n)` | [src](src/main/java/hashing/smallestpositiveinteger) | — |
| Sort Colors<br><sub>aka dutch national flag, sort zeros ones twos, leetcode 75</sub> | `two-pointers` | `array`, `dutch-national-flag`, `in-place`, `sorting`, `two-pointer` | `O(n)` | `O(1)` | — | [src](src/main/kotlin/twopointers/sortColors) |
| Spiral Matrix<br><sub>aka spiral order traversal, clockwise matrix walk</sub> | `arrays` | `boundaries`, `matrix`, `simulation` | `O(mn)` | `O(1)` | [src](src/main/java/arrays/spiraltraversal) | — |
| Squares of a Sorted Array<br><sub>aka leetcode 977, sorted squares</sub> | `two-pointers` | `array`, `sorting`, `two-pointer` | `O(n)` | `O(n)` | — | [src](src/main/kotlin/twopointers/squaresOfSortedArray) |
| Subarray Sum Equals K<br><sub>aka count contiguous subarrays with a target sum</sub> | `prefix-sum` | `array`, `hashmap`, `prefix-sum` | `O(n)` | `O(n)` | [src](src/main/java/prefixsum/subarraysum) | — |
| Two Sum<br><sub>aka two indices that add to a target, complement lookup, leetcode 1</sub> | `hashing` | `array`, `hashmap` | `O(n)` | `O(n)` | [src](src/main/java/hashing/twosum) | [src](src/main/kotlin/hashing/twoSums) |
| Two Sum — Exists<br><sub>aka does an array contain two values summing to a target, pair with target sum</sub> | `hashing` | `array`, `hashset` | `O(n)` | `O(n)` | [src](src/main/java/hashing/sumoftwovalues) | — |
| Valid Parentheses<br><sub>aka balanced brackets, matching parentheses, leetcode 20</sub> | `stack` | `stack`, `string` | `O(n)` | `O(n)` | [src](src/main/java/stack/validparenthesis) | [src](src/main/kotlin/stack/validParenthesis) |

## By pattern

Each problem lives in the directory named here. A problem usually uses more than one technique, so the pattern is the primary one; see [By technique](#by-technique) for every technique it touches.

### arrays (2)

- Count Number of Teams [k](src/main/kotlin/arrays/countNumberOfTeams)
- Spiral Matrix [j](src/main/java/arrays/spiraltraversal)

### bfs (3)

- Graph Valid Tree [j](src/main/java/bfs/graphtree)
- Level Order Traversal [j](src/main/java/bfs/levelordertraversalofbinarytree)
- Shortest Path in a Grid [j](src/main/java/bfs/shortestpath)

### binary-search (1)

- Binary Search [j](src/main/java/binarysearch/binarysearch)

### design (4)

- Deck of Cards [j](src/main/java/design/deckofcards)
- Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- LRU Cache [j](src/main/java/design/lrucache)
- Rate Limiter — Sliding Window [j](src/main/java/design/ratechecker)

### dynamic-programming (4)

- Climbing Stairs [j](src/main/java/dynamicprogramming/staircase)
- House Robber [k](src/main/kotlin/dynamicprogramming/houseRobber)
- Levenshtein Distance [j](src/main/java/dynamicprogramming/levenshteindistance)
- Longest Ideal Subsequence [k](src/main/kotlin/dynamicprogramming/longestIdealSequence)

### greedy (2)

- Average Waiting Time [k](src/main/kotlin/greedy/averageWaitingTime)
- Missing Dice Rolls [j](src/main/java/greedy/dice)

### hashing (9)

- Contains Duplicate [j](src/main/java/hashing/duplicatenumber)
- Conversation Insight [j](src/main/java/hashing/conversationinsight)
- Count of Balloon [j](src/main/java/hashing/countofballoon)
- First Unique Character [j](src/main/java/hashing/firstuniquechar)
- Group Anagrams [j](src/main/java/hashing/groupedanagram)
- Longest Consecutive Sequence [j](src/main/java/hashing/longestconsecutivesequence)
- Smallest Missing Positive Integer [j](src/main/java/hashing/smallestpositiveinteger)
- Two Sum [j](src/main/java/hashing/twosum) [k](src/main/kotlin/hashing/twoSums)
- Two Sum — Exists [j](src/main/java/hashing/sumoftwovalues)

### heap (1)

- Agent Assignment [j](src/main/java/heap/agentassignment)

### linked-list (4)

- Add Two Numbers [k](src/main/kotlin/linkedlist/addTwoNumbers)
- Maximum Twin Pair Sum [j](src/main/java/linkedlist/pagereadcounter)
- Merge Two Sorted Lists [k](src/main/kotlin/linkedlist/sortedList)
- Rotate Linked List [j](src/main/java/linkedlist/rotatelinkedlist)

### math (5)

- FizzBuzz [k](src/main/kotlin/math/fizzBuzz)
- Lucky Number [j](src/main/java/math/luckynumber)
- Missing Number [j](src/main/java/math/missingnumber)
- Multiply Without the Operator [j](src/main/java/math/multiply)
- Reverse Number [j](src/main/java/math/reverse)

### prefix-search (2)

- Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString)
- Search Suggestions System [j](src/main/java/prefixsearch/searchsuggestions)

### prefix-sum (2)

- Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle)
- Subarray Sum Equals K [j](src/main/java/prefixsum/subarraysum)

### sandbox (1)

- Kotlin Basics [k](src/main/kotlin/sandbox/kotlinBasics)

### sliding-window (3)

- Contiguous Range Sum [k](src/main/kotlin/slidingwindow/subsetSum)
- Longest Substring Without Repeating Characters [j](src/main/java/slidingwindow/longestsubstring) [k](src/main/kotlin/slidingwindow/longestSubstring)
- Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray)

### sorting (4)

- Heap Sort [j](src/main/java/sorting/heapsort)
- Merge Sort [j](src/main/java/sorting/mergesort)
- Quick Sort [j](src/main/java/sorting/quicksort)
- Selection Sort [j](src/main/java/sorting/selectionsort)

### stack (2)

- Discount Code [j](src/main/java/stack/discountcode)
- Valid Parentheses [j](src/main/java/stack/validparenthesis) [k](src/main/kotlin/stack/validParenthesis)

### strings (2)

- Fresh Promo Code [j](src/main/java/strings/freshpromocode)
- Link Unique Checker [j](src/main/java/strings/linkuniquechecker)

### trees (1)

- Invert Binary Tree [j](src/main/java/trees/invertbinarytree)

### two-pointers (3)

- Move Zeroes [j](src/main/java/twopointers/movezeros)
- Sort Colors [k](src/main/kotlin/twopointers/sortColors)
- Squares of a Sorted Array [k](src/main/kotlin/twopointers/squaresOfSortedArray)

## By technique

- **`2d-dp`** — Levenshtein Distance [j](src/main/java/dynamicprogramming/levenshteindistance)
- **`adjacency-list`** — Graph Valid Tree [j](src/main/java/bfs/graphtree)
- **`aggregation`** — Conversation Insight [j](src/main/java/hashing/conversationinsight)
- **`alphabet`** — Longest Ideal Subsequence [k](src/main/kotlin/dynamicprogramming/longestIdealSequence)
- **`array`** — Average Waiting Time [k](src/main/kotlin/greedy/averageWaitingTime), Binary Search [j](src/main/java/binarysearch/binarysearch), Contains Duplicate [j](src/main/java/hashing/duplicatenumber), Contiguous Range Sum [k](src/main/kotlin/slidingwindow/subsetSum), Count Number of Teams [k](src/main/kotlin/arrays/countNumberOfTeams), House Robber [k](src/main/kotlin/dynamicprogramming/houseRobber), Longest Consecutive Sequence [j](src/main/java/hashing/longestconsecutivesequence), Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray), Missing Dice Rolls [j](src/main/java/greedy/dice), Missing Number [j](src/main/java/math/missingnumber), Move Zeroes [j](src/main/java/twopointers/movezeros), Smallest Missing Positive Integer [j](src/main/java/hashing/smallestpositiveinteger), Sort Colors [k](src/main/kotlin/twopointers/sortColors), Squares of a Sorted Array [k](src/main/kotlin/twopointers/squaresOfSortedArray), Subarray Sum Equals K [j](src/main/java/prefixsum/subarraysum), Two Sum [j](src/main/java/hashing/twosum) [k](src/main/kotlin/hashing/twoSums), Two Sum — Exists [j](src/main/java/hashing/sumoftwovalues)
- **`autocomplete`** — Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString), Search Suggestions System [j](src/main/java/prefixsearch/searchsuggestions)
- **`bfs`** — Graph Valid Tree [j](src/main/java/bfs/graphtree), Level Order Traversal [j](src/main/java/bfs/levelordertraversalofbinarytree), Shortest Path in a Grid [j](src/main/java/bfs/shortestpath)
- **`binary-search`** — Binary Search [j](src/main/java/binarysearch/binarysearch)
- **`binary-tree`** — Invert Binary Tree [j](src/main/java/trees/invertbinarytree), Level Order Traversal [j](src/main/java/bfs/levelordertraversalofbinarytree)
- **`boolean-sieve`** — Smallest Missing Positive Integer [j](src/main/java/hashing/smallestpositiveinteger)
- **`boundaries`** — Spiral Matrix [j](src/main/java/arrays/spiraltraversal)
- **`brute-force`** — Count Number of Teams [k](src/main/kotlin/arrays/countNumberOfTeams)
- **`cache`** — LRU Cache [j](src/main/java/design/lrucache)
- **`carry`** — Add Two Numbers [k](src/main/kotlin/linkedlist/addTwoNumbers)
- **`circular-array`** — Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle)
- **`code-review`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`collections`** — Deck of Cards [j](src/main/java/design/deckofcards), Kotlin Basics [k](src/main/kotlin/sandbox/kotlinBasics)
- **`concurrency`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`connected-components`** — Graph Valid Tree [j](src/main/java/bfs/graphtree)
- **`counting`** — Count Number of Teams [k](src/main/kotlin/arrays/countNumberOfTeams), Count of Balloon [j](src/main/java/hashing/countofballoon), First Unique Character [j](src/main/java/hashing/firstuniquechar), Smallest Missing Positive Integer [j](src/main/java/hashing/smallestpositiveinteger)
- **`cycle`** — Rotate Linked List [j](src/main/java/linkedlist/rotatelinkedlist)
- **`deque`** — Maximum Twin Pair Sum [j](src/main/java/linkedlist/pagereadcounter), Rate Limiter — Sliding Window [j](src/main/java/design/ratechecker)
- **`design`** — Agent Assignment [j](src/main/java/heap/agentassignment), Deck of Cards [j](src/main/java/design/deckofcards), Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString), Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding), LRU Cache [j](src/main/java/design/lrucache), Rate Limiter — Sliding Window [j](src/main/java/design/ratechecker)
- **`dfs`** — Invert Binary Tree [j](src/main/java/trees/invertbinarytree)
- **`digits`** — Reverse Number [j](src/main/java/math/reverse)
- **`divide-and-conquer`** — Merge Sort [j](src/main/java/sorting/mergesort), Quick Sort [j](src/main/java/sorting/quicksort)
- **`doubly-linked-list`** — LRU Cache [j](src/main/java/design/lrucache)
- **`dutch-national-flag`** — Sort Colors [k](src/main/kotlin/twopointers/sortColors)
- **`dynamic-programming`** — Climbing Stairs [j](src/main/java/dynamicprogramming/staircase), House Robber [k](src/main/kotlin/dynamicprogramming/houseRobber), Levenshtein Distance [j](src/main/java/dynamicprogramming/levenshteindistance), Longest Ideal Subsequence [k](src/main/kotlin/dynamicprogramming/longestIdealSequence)
- **`edit-distance`** — Levenshtein Distance [j](src/main/java/dynamicprogramming/levenshteindistance)
- **`enum`** — Deck of Cards [j](src/main/java/design/deckofcards)
- **`gauss-sum`** — Missing Number [j](src/main/java/math/missingnumber)
- **`graph`** — Graph Valid Tree [j](src/main/java/bfs/graphtree), Shortest Path in a Grid [j](src/main/java/bfs/shortestpath)
- **`greedy`** — Average Waiting Time [k](src/main/kotlin/greedy/averageWaitingTime), Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle), Missing Dice Rolls [j](src/main/java/greedy/dice)
- **`hashmap`** — Agent Assignment [j](src/main/java/heap/agentassignment), Conversation Insight [j](src/main/java/hashing/conversationinsight), Count of Balloon [j](src/main/java/hashing/countofballoon), First Unique Character [j](src/main/java/hashing/firstuniquechar), Group Anagrams [j](src/main/java/hashing/groupedanagram), Longest Substring Without Repeating Characters [j](src/main/java/slidingwindow/longestsubstring) [k](src/main/kotlin/slidingwindow/longestSubstring), Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray), LRU Cache [j](src/main/java/design/lrucache), Subarray Sum Equals K [j](src/main/java/prefixsum/subarraysum), Two Sum [j](src/main/java/hashing/twosum) [k](src/main/kotlin/hashing/twoSums)
- **`hashset`** — Contains Duplicate [j](src/main/java/hashing/duplicatenumber), Longest Consecutive Sequence [j](src/main/java/hashing/longestconsecutivesequence), Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray), Two Sum — Exists [j](src/main/java/hashing/sumoftwovalues)
- **`heap`** — Agent Assignment [j](src/main/java/heap/agentassignment), Heap Sort [j](src/main/java/sorting/heapsort)
- **`in-place`** — Heap Sort [j](src/main/java/sorting/heapsort), Move Zeroes [j](src/main/java/twopointers/movezeros), Selection Sort [j](src/main/java/sorting/selectionsort), Sort Colors [k](src/main/kotlin/twopointers/sortColors)
- **`josephus`** — Lucky Number [j](src/main/java/math/luckynumber)
- **`language-basics`** — Kotlin Basics [k](src/main/kotlin/sandbox/kotlinBasics)
- **`linked-list`** — Add Two Numbers [k](src/main/kotlin/linkedlist/addTwoNumbers), Maximum Twin Pair Sum [j](src/main/java/linkedlist/pagereadcounter), Merge Two Sorted Lists [k](src/main/kotlin/linkedlist/sortedList), Rotate Linked List [j](src/main/java/linkedlist/rotatelinkedlist)
- **`math`** — Add Two Numbers [k](src/main/kotlin/linkedlist/addTwoNumbers), FizzBuzz [k](src/main/kotlin/math/fizzBuzz), Lucky Number [j](src/main/java/math/luckynumber), Missing Dice Rolls [j](src/main/java/greedy/dice), Missing Number [j](src/main/java/math/missingnumber), Multiply Without the Operator [j](src/main/java/math/multiply), Reverse Number [j](src/main/java/math/reverse)
- **`matrix`** — Shortest Path in a Grid [j](src/main/java/bfs/shortestpath), Spiral Matrix [j](src/main/java/arrays/spiraltraversal)
- **`median`** — Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle)
- **`memoization`** — Climbing Stairs [j](src/main/java/dynamicprogramming/staircase)
- **`merge`** — Merge Two Sorted Lists [k](src/main/kotlin/linkedlist/sortedList)
- **`normalization`** — Link Unique Checker [j](src/main/java/strings/linkuniquechecker)
- **`observer`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`one-pass`** — Conversation Insight [j](src/main/java/hashing/conversationinsight)
- **`oop`** — Deck of Cards [j](src/main/java/design/deckofcards)
- **`partition`** — Quick Sort [j](src/main/java/sorting/quicksort)
- **`pattern-matching`** — Fresh Promo Code [j](src/main/java/strings/freshpromocode)
- **`playground`** — Kotlin Basics [k](src/main/kotlin/sandbox/kotlinBasics)
- **`prefix`** — Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString), Search Suggestions System [j](src/main/java/prefixsearch/searchsuggestions)
- **`prefix-sum`** — Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle), Subarray Sum Equals K [j](src/main/java/prefixsum/subarraysum)
- **`priority-queue`** — Agent Assignment [j](src/main/java/heap/agentassignment)
- **`pub-sub`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`queue`** — Graph Valid Tree [j](src/main/java/bfs/graphtree), Level Order Traversal [j](src/main/java/bfs/levelordertraversalofbinarytree), Shortest Path in a Grid [j](src/main/java/bfs/shortestpath)
- **`rate-limiting`** — Rate Limiter — Sliding Window [j](src/main/java/design/ratechecker)
- **`recursion`** — Climbing Stairs [j](src/main/java/dynamicprogramming/staircase), Invert Binary Tree [j](src/main/java/trees/invertbinarytree), Lucky Number [j](src/main/java/math/luckynumber), Merge Sort [j](src/main/java/sorting/mergesort), Multiply Without the Operator [j](src/main/java/math/multiply), Quick Sort [j](src/main/java/sorting/quicksort)
- **`reduction`** — Discount Code [j](src/main/java/stack/discountcode)
- **`regex`** — Fresh Promo Code [j](src/main/java/strings/freshpromocode)
- **`shortest-path`** — Shortest Path in a Grid [j](src/main/java/bfs/shortestpath)
- **`simulation`** — Agent Assignment [j](src/main/java/heap/agentassignment), Average Waiting Time [k](src/main/kotlin/greedy/averageWaitingTime), FizzBuzz [k](src/main/kotlin/math/fizzBuzz), Spiral Matrix [j](src/main/java/arrays/spiraltraversal)
- **`singleton`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`sliding-window`** — Contiguous Range Sum [k](src/main/kotlin/slidingwindow/subsetSum), Longest Substring Without Repeating Characters [j](src/main/java/slidingwindow/longestsubstring) [k](src/main/kotlin/slidingwindow/longestSubstring), Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray), Rate Limiter — Sliding Window [j](src/main/java/design/ratechecker)
- **`sorted-array`** — Binary Search [j](src/main/java/binarysearch/binarysearch)
- **`sorting`** — Group Anagrams [j](src/main/java/hashing/groupedanagram), Heap Sort [j](src/main/java/sorting/heapsort), Merge Sort [j](src/main/java/sorting/mergesort), Minimum Circular Alignment Cost [j](src/main/java/prefixsum/angle), Quick Sort [j](src/main/java/sorting/quicksort), Search Suggestions System [j](src/main/java/prefixsearch/searchsuggestions), Selection Sort [j](src/main/java/sorting/selectionsort), Sort Colors [k](src/main/kotlin/twopointers/sortColors), Squares of a Sorted Array [k](src/main/kotlin/twopointers/squaresOfSortedArray)
- **`stack`** — Discount Code [j](src/main/java/stack/discountcode), Valid Parentheses [j](src/main/java/stack/validparenthesis) [k](src/main/kotlin/stack/validParenthesis)
- **`string`** — Conversation Insight [j](src/main/java/hashing/conversationinsight), Count of Balloon [j](src/main/java/hashing/countofballoon), Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString), Discount Code [j](src/main/java/stack/discountcode), First Unique Character [j](src/main/java/hashing/firstuniquechar), FizzBuzz [k](src/main/kotlin/math/fizzBuzz), Fresh Promo Code [j](src/main/java/strings/freshpromocode), Group Anagrams [j](src/main/java/hashing/groupedanagram), Levenshtein Distance [j](src/main/java/dynamicprogramming/levenshteindistance), Link Unique Checker [j](src/main/java/strings/linkuniquechecker), Longest Ideal Subsequence [k](src/main/kotlin/dynamicprogramming/longestIdealSequence), Longest Substring Without Repeating Characters [j](src/main/java/slidingwindow/longestsubstring) [k](src/main/kotlin/slidingwindow/longestSubstring), Search Suggestions System [j](src/main/java/prefixsearch/searchsuggestions), Valid Parentheses [j](src/main/java/stack/validparenthesis) [k](src/main/kotlin/stack/validParenthesis)
- **`substring`** — Link Unique Checker [j](src/main/java/strings/linkuniquechecker)
- **`thread-safety`** — Event Dispatcher — Live Coding Review [j](src/main/java/design/db/livecoding)
- **`treeset`** — Agent Assignment [j](src/main/java/heap/agentassignment)
- **`trie`** — Design Search Autocomplete [k](src/main/kotlin/prefixsearch/searchString)
- **`two-pointer`** — Contiguous Range Sum [k](src/main/kotlin/slidingwindow/subsetSum), Longest Substring Without Repeating Characters [j](src/main/java/slidingwindow/longestsubstring) [k](src/main/kotlin/slidingwindow/longestSubstring), Longest Unique Subarray [j](src/main/java/slidingwindow/longestuniquesubarray), Maximum Twin Pair Sum [j](src/main/java/linkedlist/pagereadcounter), Merge Two Sorted Lists [k](src/main/kotlin/linkedlist/sortedList), Move Zeroes [j](src/main/java/twopointers/movezeros), Rotate Linked List [j](src/main/java/linkedlist/rotatelinkedlist), Sort Colors [k](src/main/kotlin/twopointers/sortColors), Squares of a Sorted Array [k](src/main/kotlin/twopointers/squaresOfSortedArray)

<!-- END INDEX -->
