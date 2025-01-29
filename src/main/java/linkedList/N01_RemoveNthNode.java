package linkedList;

public class N01_RemoveNthNode {
    /**
     * Given a linked list head remove the nth node from the end
     *
     * Explanation:
     *      create a dummy node = head
     *      have a fast pointer and a slow pointer both pointing to head
     *      first move the slow pointer by t steps
     *      then move both the fast nd slow pointer by 1 step timm fast pointer next. null
     *      then delete node at slow pointer
     *
     */

    public Node<Integer> removeNthNodeFromBehind(Node<Integer> head, int n){

        Node start=new Node();
        start.next=head;
        Node slow= start;
        Node fast= start;

        for (int i=0;i<n;i++) fast=fast.next;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;
    }
}
