fun main() {
    println("Main.kt")
//    val list = listOf("ab", "de")
//    list.forEachIndexed { index, item ->
//        println(index)
//        println(item)
//    }
//
//    for ((index, item) in list.withIndex()) {
//        println(index)
//        println(item)
//    }
//    val set = mutableSetOf("abc", "def")
//
//    for ((index, item) in set.withIndex()) {
//        println(index)
//        println(item)
//    }
//    set.add("abc")

//    val map = mutableMapOf("a" to "1", "b" to 2, "c" to 3)
//    map["d"] = 4
//
//    println(map)

//    val arr= arrayOf(1,3,4)
//    arr[2] = 1
//    println(arr.joinToString())
//    val arr = arrayOfNulls<String>(5)
//    val intArr = IntArray(5)
//    val a = Array(5) { 0 }
//    val hash = hashMapOf("a" to 1, "b" to 2)
//    hash["c"] = 3
//    println(hash)
//    hash.remove("b")
//    println(hash)

    val str = "aba"
    var rstr = ""
    val cstr = str.toCharArray()
    val n = cstr.size
    for (i in cstr.indices) {
        rstr += cstr[n - i - 1]
    }
    println(rstr == str)
}