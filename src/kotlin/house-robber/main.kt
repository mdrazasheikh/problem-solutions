class Solution {
    // time  o(n), space o(n(
    fun rob(nums: IntArray): Int {
        if(nums.isEmpty()){
            return 0
        }
        if(nums.size == 1){
            return nums[0]
        }

        var dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for(i in 2 until nums.size){
            dp[i] = maxOf(dp[i-1], nums[i] + dp[i-2])
        }

        return dp.last()
    }

    // time o(n) space o(1)
    fun rob2(nums: IntArray): Int {
        if(nums.isEmpty()){
            return 0
        }
        if(nums.size == 1){
            return nums[0]
        }

        var prev1 = nums[0]
        var prev2 = max(nums[0], nums[1])

        for(i in 2 until nums.size){
            val current = maxOf(prev2, nums[i] + prev1)
            prev1 = prev2
            prev2 = current
        }

        return prev2
    }

}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 1)
    val nums2 = intArrayOf(2, 7, 9, 3, 1)

    println(rob(nums1))  // Output: 4
    println(rob(nums2))  // Output: 12
}