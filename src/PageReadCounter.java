import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }
}


class Result {
    public static int maximumPages(SinglyLinkedListNode head) {

        Deque<Integer> deque = new ArrayDeque<>();

        while (head != null){
            System.out.println("here");

            deque.add(head.data);
            head = head.next;
        }

        int maximum = 0;
        while (!deque.isEmpty()){
            Integer first = deque.pollFirst();
            Integer last = deque.pollLast();
            int total = first + last;
            maximum = Math.max(maximum, total);
        }

        return maximum;
    }

}

public class PageReadCounter {
    public static void main(String[] args) throws IOException {
        SinglyLinkedList head = new SinglyLinkedList();

        head.insertNode(3);
        head.insertNode(1);
        head.insertNode(1);
        head.insertNode(3);

        int result = Result.maximumPages(head.head);

        System.out.println(result);
    }
}
