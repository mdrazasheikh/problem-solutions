public class Staircase {

    public static int numWaysRecursive(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return numWaysRecursive(n - 1) + numWaysRecursive(n - 2);
    }

    public static int numWaysBottomUp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] nums = new int[n + 1];

        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n];
    }

    public static int numWaysRecursiveHardCodeX(int n) {
        if (n == 0) {
            return 1;
        }

        return numWaysRecursive(n - 1) + numWaysRecursive(n - 3) + numWaysRecursive(n - 5);
    }

    public static int numWaysRecursiveX(int n) {
        if (n == 0) {
            return 1;
        }
        int total = 0;
        int[] x = new int[]{1, 3, 5};

        for (int i : x) {
            if (n - i >= 0) {
                total += numWaysRecursiveX(n - i);
            }
        }

        return total;
    }

    public static int numWaysBottomUpX(int n) {
        if (n == 0) {
            return 1;
        }

        int[] x = new int[]{1, 3, 5};
        int[] nums = new int[n + 1];

        nums[0] = 1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j : x) {
                if (i - j >= 0) {
                    total += nums[i - j];
                }
            }
            nums[i] = total;
        }

        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numWaysBottomUp(3));
        System.out.println(numWaysRecursiveHardCodeX(3));
        System.out.println(numWaysRecursiveX(3));
        System.out.println(numWaysBottomUpX(5));
    }
}
