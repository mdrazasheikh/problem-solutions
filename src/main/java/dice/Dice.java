package dice;

import java.util.Arrays;

public class Dice {
    public int[] solution(int[] A, int F, int M) {
        // Implement your solution here
        // (3 + 2 + 4 + 3 + x + y)/6 = 4
        // (1 + 5 + 6 + a + b + c + d) / 8 = 3
        int knownSum = 0;
        for (int num : A) {
            knownSum += num;
        }

        int totalRolls = A.length + F;
        int requiredSum = M * totalRolls - knownSum;

        if (requiredSum < F || requiredSum > 6 * F) {
            return new int[]{0};
        }

        int[] result = new int[F];
        Arrays.fill(result, 1);

        requiredSum -= F;

        int i = 0;
        while (requiredSum > 0) {
            int add = Math.min(5, requiredSum);
            result[i] += add;
            requiredSum -= add;
            i++;
        }

        return result;
    }

    void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 4, 3}, 2, 4)));
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 6}, 4, 3)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4, 6)));
        System.out.println(Arrays.toString(solution(new int[]{6, 1}, 1, 1)));
    }

    /**
     * Example test:   ([3, 2, 4, 3], 2, 4)
     * OK
     *
     * Example test:   ([1, 5, 6], 4, 3)
     * OK
     *
     * Example test:   ([1, 2, 3, 4], 4, 6)
     * OK
     *
     * Example test:   ([6, 1], 1, 1)
     * OK
     */
}
