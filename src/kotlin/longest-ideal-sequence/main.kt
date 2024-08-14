class Solution {
    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(26) { 0 }
        var maxLen = 0

        for (ch in s) {
            var idx = ch - 'a'
            var maxPrevLen = 0

            for (i in (idx - k).coerceAtLeast(0)..(idx + k).coerceAtMost(25)) {
                maxPrevLen = maxOf(maxPrevLen, dp[i])
            }

            dp[idx] = maxPrevLen + 1
            maxLen = maxOf(maxLen, dp[idx])
        }

        return maxLen
    }
}


fun main() {
    val s1 = "acfgbd"
    val k1 = 2
    println(longestIdealString(s1, k1)) // Output: 4

    val s2 = "abcd"
    val k2 = 3
    println(longestIdealString(s2, k2)) // Output: 4
}