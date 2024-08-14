// #### Add Two Numbers:
// Given two non-empty linked lists representing two non-negative integers, add the two numbers and return it as a linked list.

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var p = l1
    var q = l2
    var current = dummyHead
    var carry = 0

    while (p != null || q != null) {
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0

        val sum = carry + x + y
        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!

        p = p?.next
        q = q?.next
    }
    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummyHead.next
}

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)

    val l2 = ListNode(3)
    l2.next = ListNode(4)

    printList(addTwoNumbers(l1, l2))
}