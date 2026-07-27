package twosum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not found");
    }

    void main(String[] args) {
        var nums = new int[]{1, 5, 3, 8, 4};
        var target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
