public static boolean isValidTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false; // quick structural check

    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
    for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
    }

    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited.add(0);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int nei : adj.get(node)) {
            if (visited.contains(nei)) continue;
            visited.add(nei);
            queue.add(nei);
        }
    }

    return visited.size() == n;
}

void main() {
    int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    IO.println(isValidTree(5, edges1)); // true

    int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
    IO.println(isValidTree(3, edges2)); // false (cycle)

    int[][] edges3 = {{0, 1}, {2, 3}};
    IO.println(isValidTree(4, edges3)); // false (disconnected)
}
