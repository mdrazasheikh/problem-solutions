// #### Longest Substring Without Repeating Characters:
// Given a string, find the length of the longest substring without repeating characters.

fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    var maxLen = 0
    var left = 0
    for (right in s.indices) {
        if (map.containsKey(s[right])) {
            left = maxOf(map[s[right]]!! + 1, left)
        }
        map[s[right]] = right
        maxLen = maxOf(maxLen, right - left + 1)
    }
    return maxLen
}

fun main() {
    println(lengthOfLongestSubstring("some string"))
}