package subarraysum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }

            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
