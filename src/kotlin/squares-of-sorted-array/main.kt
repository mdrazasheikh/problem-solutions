class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        var left = 0
        var right = n - 1
        var index = n - 1

        while(left <= right){
            val leftSquare = nums[left] * nums[left]
            val rightSquare = nums[right] * nums[right]

            if(leftSquare > rightSquare){
                result[index] = leftSquare
                left++
            }else{
                result[index] = rightSquare
                right--
            }
            index--
        }
        return result
    }
}

fun main() {
    val nums1 = intArrayOf(-4, -1, 0, 3, 10)
    val nums2 = intArrayOf(-7, -3, 2, 3, 11)

    println(sortedSquares(nums1).joinToString(", "))  // Output: 0, 1, 9, 16, 100
    println(sortedSquares(nums2).joinToString(", "))  // Output: 4, 9, 9, 49, 121
}
