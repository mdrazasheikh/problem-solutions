package mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] previous = result.getLast();

            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    static void main(String[] args) {
        var instance = new MergeInterval();

        System.out.println(Arrays.deepToString(instance.mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 12}})));
        System.out.println();
        System.out.println(Arrays.deepToString(instance.mergeIntervals(new int[][]{{1, 4}, {4, 5}})));
    }
}
