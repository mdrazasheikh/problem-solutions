package slidingwindow.longestuniquesubarray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestUniqueSubArray {

    public int longestUniqueSubArray(int[] nums) {
        var visited = new HashSet<Integer>();

        int maxLength = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            while (visited.contains(nums[right])) {
                visited.remove(nums[left]);
                left++;
            }

            visited.add(nums[right]);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int longestUniqueSubArray2(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        int maxLength = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            var current = nums[right];

            if (lastSeen.containsKey(current)) {
                left = Math.max(left, lastSeen.get(current) + 1);
            }

            lastSeen.put(current, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    static void main(String[] args) {
        var instance = new LongestUniqueSubArray();
        System.out.println(instance.longestUniqueSubArray(new int[]{1, 2, 3, 1, 2}));
        System.out.println(instance.longestUniqueSubArray(new int[]{1, 2, 3, 1, 4, 2}));
        System.out.println(instance.longestUniqueSubArray(new int[]{5, 5, 5}));
        System.out.println(instance.longestUniqueSubArray(new int[]{1, 2, 3, 4}));

        System.out.println();

        System.out.println(instance.longestUniqueSubArray2(new int[]{1, 2, 3, 1, 2}));
        System.out.println(instance.longestUniqueSubArray2(new int[]{1, 2, 3, 1, 4, 2}));
        System.out.println(instance.longestUniqueSubArray2(new int[]{5, 5, 5}));
        System.out.println(instance.longestUniqueSubArray2(new int[]{1, 2, 3, 4}));
    }
}
