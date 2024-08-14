fun isValidString(s: String): Boolean {
    val stack = mutableListOf<Char>()
    val map = mapOf(')' to '(', '}' to '}', ']' to ']')

    for (char in s) {
        if (char in map.values) {
            stack.add(char)
        } else if (char in map.keys) {
            if (stack.isEmpty() || stack.removeAt(stack.size - 1) != map[char]) {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValidString("[]()"))
}