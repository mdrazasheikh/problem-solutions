package shortestpath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShortestPathTest {

    private static final int NO_PATH = -1;

    private final ShortestPath path = new ShortestPath();

    @Test
    void countsCellsAlongTheShortestRoute() {
        assertEquals(5, path.getShortestPathLength(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        }));
    }

    @Test
    void routesAroundAnObstacleRatherThanThroughIt() {
        assertEquals(5, path.getShortestPathLength(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }

    @Test
    void handlesASingleOpenCell() {
        assertEquals(1, path.getShortestPathLength(new int[][]{{0}}));
    }

    @Test
    void walksAStraightCorridor() {
        assertEquals(4, path.getShortestPathLength(new int[][]{{0, 0, 0, 0}}));
    }

    @Test
    void rejectsABlockedStart() {
        assertEquals(NO_PATH, path.getShortestPathLength(new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        }));
    }

    @Test
    void rejectsABlockedEnd() {
        assertEquals(NO_PATH, path.getShortestPathLength(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1},
        }));
    }

    @Test
    void rejectsBothEndsBlocked() {
        assertEquals(NO_PATH, path.getShortestPathLength(new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    void reportsNoPathWhenTheTargetIsUnreachable() {
        assertEquals(NO_PATH, path.getShortestPathLength(new int[][]{
                {0, 1},
                {1, 0},
        }));
    }

    @Test
    void reportsNoPathWhenAWallSplitsTheGrid() {
        assertEquals(NO_PATH, path.getShortestPathLength(new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0},
        }));
    }

    @Test
    void doesNotMoveDiagonally() {
        // A diagonal step would make this 3; only orthogonal moves are allowed, so the
        // route has to go around.
        assertEquals(5, path.getShortestPathLength(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }
}
