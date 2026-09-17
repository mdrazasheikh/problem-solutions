package validparenthesis

// #### Valid Parentheses:
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.

private val CLOSING_TO_OPENING = mapOf(')' to '(', '}' to '{', ']' to '[')

fun isValidString(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (char in s) {
        when (char) {
            in CLOSING_TO_OPENING.values -> stack.addLast(char)
            in CLOSING_TO_OPENING.keys ->
                if (stack.removeLastOrNull() != CLOSING_TO_OPENING[char]) return false
        }
    }

    return stack.isEmpty()
}

fun main() {
    println(isValidString("[]()"))   // true
    println(isValidString("{[()]}")) // true
    println(isValidString("([)]"))   // false
}
