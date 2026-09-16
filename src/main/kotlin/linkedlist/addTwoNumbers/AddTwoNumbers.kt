package addtwonumbers

// #### Add Two Numbers:
// Given two non-empty linked lists representing two non-negative integers, add the two numbers and return it as a linked list.

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    println("null")
}

fun addTwoNumbers(leftList: ListNode?, rightList: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var leftNode = leftList
    var rightNode = rightList
    var current = dummyHead
    var carry = 0

    while (leftNode != null || rightNode != null) {
        val leftValue = leftNode?.value ?: 0
        val rightValue = rightNode?.value ?: 0

        val sum = carry + leftValue + rightValue
        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!

        leftNode = leftNode?.next
        rightNode = rightNode?.next
    }
    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummyHead.next
}

fun main() {
    val firstList = ListNode(1)
    firstList.next = ListNode(2)

    val secondList = ListNode(3)
    secondList.next = ListNode(4)

    printList(addTwoNumbers(firstList, secondList))
}
