package angle;

import java.util.Arrays;

public class Angle {

    public int solution(int[] A) {
        int n = A.length;
        Arrays.sort(A);

        int[] b = new int[2 * n];

        for (int i = 0; i < n; i++) {
            b[i] = A[i];
            b[i + n] = A[i] + 360;
        }

        long[] runningSum = new long[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            runningSum[i + 1] = runningSum[i] + b[i];
        }

        long minCost = Long.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int end = start + n - 1;
            int mid = (start + end) / 2;
            int median = b[mid];

            long leftCost = (long) median * (mid - start) - (runningSum[mid] - runningSum[start]);
            long rightCost = runningSum[end + 1] - runningSum[mid + 1] - (long) median * (end - mid);

            minCost = Math.min(minCost, leftCost + rightCost);
        }

        return (int) minCost;
    }
}

/**
 * Example test:   [20, 50, 100, 200]
 * OK
 *
 * Example test:   [350, 0, 0]
 * OK
 *
 * Example test:   [270, 301, 301, 302, 50, 70, 100]
 * OK
 */
