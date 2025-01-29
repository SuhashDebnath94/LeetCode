package blind75.LinkedList;

public class ReorderList {
//    You are given the head of a singly linked list.
//The list can be represented as :
//    L0 → L1 → … → Ln - 1 → Ln
//    Reorder the list to be on the following form:
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

//    N = 5, List = {1, 2, 3, 4, 5}
//
//    Output: 1->5 -> 2-> 4-> 3

//    Algorithm:
//             Find the midpoint and split the linked list into two halves from there.
//            Now, Reverse the second half of the list.
//            Now, connect both lists (A and B) such that  A0 -> B0 -> A1 -> B1 -> A2 -> B2 ….

    ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;

        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode mid = middle(head);
        ListNode k = reverse(mid.next);
        mid.next = null;

        ListNode c1 = head;
        ListNode c2 = k;
        ListNode f1 = null;
        ListNode f2 = null;

        while(c1 != null && c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }
}

