package linkedList;

public class N02_MiddleOfLinkedList {
    /**
     * Given a linked list head give the middle of the linked list. If the size is even return the second middle node
     */

    public Node<Integer> getMiddleNode(Node<Integer> head) {
        Node start = new Node();
        start.next = head;
        Node slow = start;
        Node fast = start;
        int n = 0;

        while (fast.next != null) {
            fast = fast.next;
            n++;
        }

        int middle = n / 2;
        n = 0;

        while (n <= middle + 1) {
            slow = slow.next;
        }
        return slow;

    }

    //More optimized
    public Node<Integer> getMiddleNodeOptimized(Node<Integer> head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // move the fast pointer by 2
            slow = slow.next; // move the slow pointer by 1
        }

        return slow;
    }
}
