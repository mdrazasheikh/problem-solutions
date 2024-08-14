// #### Merge Two Sorted Lists:
// Merge two sorted linked lists and return it as a new list.

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    var p1 = l1
    var p2 = l2

    while (p1 != null && p2 != null) {
        if (p1.`val` <= p2.`val`) {
            current.next = p1
            p1 = p1.next
        } else {
            current.next = p2
            p2 = p2.next
        }
        current = current.next!!
    }
    if (p1 != null) current.next = p1
    if (p2 != null) current.next = p2

    return dummy.next
}

// Helper function to print the linked list
fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun main() {
    // Create the first linked list: 1 -> 3 -> 5
    val l1 = ListNode(1)
    l1.next = ListNode(3)
    l1.next!!.next = ListNode(5)

// Create the second linked list: 2 -> 4 -> 6
    val l2 = ListNode(2)
    l2.next = ListNode(4)
    l2.next!!.next = ListNode(6)

// Merge the two linked lists
    val mergedList = mergeTwoLists(l1, l2)

// Print the merged linked list
    printList(mergedList)
}