class Solution {
    fun numTeams(rating: IntArray): Int {
        var count = 0
        var n = rating.size

        for(i in 1 until n - 1){
            var leftSmaller = 0
            var leftLarger = 0
            var rightSmaller = 0
            var rightLarger = 0

            for (j in 0 until i){
                if(rating[j] < rating[i]) leftSmaller++
                if(rating[j] > rating[i]) leftLarger++
            }

            for (k in i+1 until n){
                if(rating[k] < rating[i]) rightSmaller++
                if(rating[k] > rating[i]) rightLarger++
            }

            count += leftSmaller * rightLarger + leftLarger * rightSmaller
        }
        return count
    }
}

fun main() {
    val rating1 = intArrayOf(2, 5, 3, 4, 1)
    val rating2 = intArrayOf(2, 1, 3)
    val rating3 = intArrayOf(1, 2, 3, 4)

    println(numTeams(rating1))  // Output: 3
    println(numTeams(rating2))  // Output: 0
    println(numTeams(rating3))  // Output: 4
}