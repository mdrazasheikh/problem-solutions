package hashing.smallestpositiveinteger;

public class SmallestPositiveInteger {

    int smallestPositiveInteger(int[] A) {
        if (A == null) {
            return 1;
        }

        int n = A.length;
        boolean[] seenNums = new boolean[n + 2];

        for (int num : A) {
            if (num > 0 && num <= n + 1) {
                seenNums[num] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!seenNums[i]) {
                return i;
            }
        }

        return n + 1;

    }

    void main() {
        System.out.println(smallestPositiveInteger(new int[]{1, 3, 2, 7, 4}));
    }
}
