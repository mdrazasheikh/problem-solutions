package rotatelinkedlist;

public class RotateLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Avoid unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make circular
        tail.next = head;

        // Find new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }

    public static ListNode build(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + (node.next == null ? "" : " -> "));
        }
        System.out.println();
    }

    void main(String[] args) {
        print(rotateRight(build(1, 2, 3, 4, 5), 2)); // 4 -> 5 -> 1 -> 2 -> 3
        print(rotateRight(build(0, 1, 2), 4));       // 2 -> 0 -> 1
        print(rotateRight(build(1, 2, 3), 3));       // 1 -> 2 -> 3
        print(rotateRight(build(1), 10));            // 1
    }
}
