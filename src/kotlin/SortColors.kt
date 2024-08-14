// #### Sort Colors:
// Given an array with n objects colored red, white, or blue, java.sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

fun sortColors(nums: Array<String>) {
    var low = 0
    var mid = 0
    var high = nums.size - 1

    while (mid <= high) {
        when (nums[mid]) {
            "red" -> {
                nums[low] = nums[mid].also { nums[mid] = nums[low] }
                low++
                mid++
            }

            "white" -> {
                mid++
            }

            "blue" -> {
                nums[high] = nums[mid].also { nums[mid] = nums[high] }
                high--
            }
        }
    }
}

fun main() {
    val nums = arrayOf("blue", "white", "red", "red", "white", "blue")
    sortColors(nums)
    println(nums.toList())
}