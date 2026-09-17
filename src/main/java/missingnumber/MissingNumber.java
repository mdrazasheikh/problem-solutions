package missingnumber;

public class MissingNumber {
    int missingNumber(int[] nums) {
        var numLength = nums.length;
        var expectedSum = numLength * (numLength + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    void main(String[] args) {
        System.out.println(missingNumber(new int[]{2, 1, 5, 6, 3, 4}));
    }
}
