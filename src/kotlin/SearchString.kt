//Description
//Your task is to implement an API that offers autocomplete suggestions as a user types a query into the Miro search bar. The autocomplete suggestions should be generated based on the user's input, quickly and efficiently.
//
//
//To achieve this task, create an Autocomplete class with the following requirements:
//
//The constructor should initialize an empty data structure for storing sentences, which are composed of one or more words divided by whitespace.
//Implement an insert(sentence) method that allows adding sentences to the data structure one at a time.
//Implement a suggest(prefix) method that takes a prefix string as an argument and returns a list of sentences from the stored data that share the same prefix as the given prefix argument. The order is not important.
//
//Input / Output
//
//Test Cases
//Input
//10
//INSERT:hello
//INSERT:i love miro
//INSERT:ironman
//INSERT:islands
//INSERT:i love cookies
//INSERT:iron
//SUGGEST:i lov
//SUGGEST:iro
//SUGGEST:ie
//SUGGEST:is
//10
//INSERT:hello
//INSERT:i love miro
//INSERT:ironman
//INSERT:islands
//INSERT:i love cookies
//INSERT:iron
//SUGGEST:i lov
//SUGGEST:iro
//SUGGEST:ie
//SUGGEST:is

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    val sentences = mutableListOf<String>()
}

class Autocomplete {
    private val root = TrieNode()
    fun insert(sentence: String) {
        var node = root
        for (char in sentence) {
            node = node.children.computeIfAbsent(char) { TrieNode() }
            node.sentences.add(sentence)
        }
    }

    fun suggest(prefix: String): List<String> {
        var node = root
        for (char in prefix) {
            node = node.children[char] ?: return emptyList()
        }
        return node.sentences
    }
}


fun main(args: Array<String>) {

    val autocomplete = Autocomplete()
    autocomplete.insert("hello")
    autocomplete.insert("i love miro")
    autocomplete.insert("ironman")
    autocomplete.insert("islands")
    autocomplete.insert("i love cookies")
    autocomplete.insert("iron")

    println(autocomplete.suggest("i lov")) // returns ["i love miro", "i love cookies"]
    println(autocomplete.suggest("iro")) // returns ["ironman", "iron"]
    println(autocomplete.suggest("ie")) // returns []
    println(autocomplete.suggest("is")) // returns ["islands"]
}