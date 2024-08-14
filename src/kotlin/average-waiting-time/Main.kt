fun averageWaitingTime(customers: Array<IntArray>): Double {
    var currentTime = 0
    var totalWaitTime = 0.0
    for (customer in customers) {
        val arrivalTime = customer[0]
        val cookingTime = customer[1]

        currentTime = maxOf(currentTime, arrivalTime)

        val waitTime = currentTime + cookingTime - arrivalTime

        totalWaitTime += waitTime

        currentTime += cookingTime
    }

    return totalWaitTime / customers.size
}

fun main() {
    val customers1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(4, 3))
    val customers2 = arrayOf(intArrayOf(5, 2), intArrayOf(5, 4), intArrayOf(10, 3))

    println(averageWaitingTime(customers1)) // Output: 5.0
    println(averageWaitingTime(customers2)) // Output: 3.6666666666666665
}