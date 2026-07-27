package duplicatenumber;

import java.util.HashSet;

public class DuplicateNumber {
    boolean duplicateNumber(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        var counter = new HashSet<Integer>();
        for (int num : nums) {
            if (counter.contains(num)) {
                return true;
            } else {
                counter.add(num);
            }
        }
        return false;
    }

    void main(String[] args) {
        System.out.println(duplicateNumber(new int[]{1, 4, 6}));
    }
}
