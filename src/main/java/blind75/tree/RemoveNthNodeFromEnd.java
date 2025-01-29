package blind75.tree;

public class RemoveNthNodeFromEnd {
//    Given a linked list, and a number N. Find the Nth node from the end of this linked list and delete it.
//    Return the head of the new modified linked list.

//    Input: head = [1,2,3,4,5], n = 2
//
//    Output: [1,2,3,5]

    //    Algorithm:
//        1) there will be 2 pointers slow and fast both pointing at head
//        2) move fast for n times
//        3) move slow and fast one node at a time till fast.next == null
//        4) slow.next= slow.next.next
    class Node {

        int data;
        Node next;
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start;
        Node slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
