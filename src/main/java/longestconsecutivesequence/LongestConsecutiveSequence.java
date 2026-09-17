package longestconsecutivesequence;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    int longestConsecutiveSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int len = 1;

                while (set.contains(current + 1)) {
                    current++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{100, 4, 200, 3, 1, 2}));
    }
}
