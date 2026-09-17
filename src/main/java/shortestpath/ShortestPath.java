package shortestpath;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPath {

    private static final int NO_PATH = -1;

    public int getShortestPathLength(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        // Either endpoint being blocked rules out a path; checking only for both being
        // blocked would let a blocked start be enqueued and expanded as if it were open.
        if (graph[0][0] == 1 || graph[m - 1][n - 1] == 1) {
            return NO_PATH;
        }

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                if (row == m - 1 && col == n - 1) {
                    return distance;
                }

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextRow < m &&
                            nextCol >= 0 && nextCol < n &&
                            graph[nextRow][nextCol] == 0 &&
                            !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            distance++;
        }
        // The queue drained without reaching the target, so nothing connects the two
        // corners. Returning `distance` here would read as a valid path length.
        return NO_PATH;
    }

    static void main(String[] args) {
        System.out.println(new ShortestPath().getShortestPathLength(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        })); // 5

        System.out.println(new ShortestPath().getShortestPathLength(new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        })); // -1: the start corner is blocked
    }

}
