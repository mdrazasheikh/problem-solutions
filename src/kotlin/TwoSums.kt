// #### Two Sum:
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

fun twoSums(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for ((index, value) in nums.withIndex()) {
        val complement = target - value
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, index)
        }
        map[value] = index
    }
    throw IllegalArgumentException("Not found")
}

fun main() {
    println(twoSums(intArrayOf(4, 5, 5, 7, 9), 9).toList())
}