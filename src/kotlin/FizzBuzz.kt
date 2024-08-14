// #### FizzBuzz:
// Write a program that outputs the string representation of numbers from 1 to n, replacing multiples of three with "Fizz", multiples of five with "Buzz", and multiples of both with "FizzBuzz".

fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()

    for (i in 1..n) {
        when {
            i % 15 == 0 -> result.add("FizzBuzz")
            i % 3 == 0 -> result.add("Fizz")
            i % 5 == 0 -> result.add("Buzz")
            else -> result.add(i.toString())
        }
    }
    return result
}

fun main() {
    println(fizzBuzz(20))
}