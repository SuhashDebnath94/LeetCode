package linkedList;

public class N07_RotateLinkedList {
    /**
     * Given a linked list head and k, rotate it by k time
     */

    public static void addToTheLast(Node head, Node node)
    {
        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Method to print linked list */
    static void printList(Node<Integer> head)
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String args[])
    {

        Node<Integer> list1=new Node<>(1);
        addToTheLast(list1, new Node(2));
        addToTheLast(list1, new Node(3));
        addToTheLast(list1, new Node(4));
        addToTheLast(list1, new Node(5));


        System.out.println("Actual list is: ");
        printList(list1);

        list1= rotate(list1, 3);
        System.out.println("Result is: ");
        printList(list1);
    }

    private static Node<Integer> rotate(Node<Integer> head, int k) {
        Node<Integer> fast=head;
        Node<Integer> slow=head;

        if(head==null) return head;

        int length=1;

        while(fast.next!=null){
            fast=fast.next;
            length++;
        }

        if(k==length) return head;
        if(k>length) k=k%length;

        for(int i=1;i<(length-k);i++){
            slow=slow.next;
        }

        fast.next=head;
        head=slow.next;
        slow.next=null;

        return head;

//        T=O(N)

    }

}
