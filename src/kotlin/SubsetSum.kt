fun findFirstSubsetWithSum(arr: IntArray, targetSum: Int): List<Int> {
    val targetIndices = mutableListOf<Int>()
    var startIndex = 0
    var currentSum = 0

    for (endIndex in arr.indices) {
        currentSum += arr[endIndex]

        while (currentSum > targetSum && startIndex <= endIndex) {
            currentSum -= arr[startIndex]
            startIndex++
        }

        if (currentSum == targetSum) {
            targetIndices.add(startIndex)
            targetIndices.add(endIndex)
            break
        }
    }

    return targetIndices
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    val targetSum = 7
    val result = findFirstSubsetWithSum(arr, targetSum)
    println(result.joinToString()) // Output: 2, 4 (for the subset [3, 4])
}