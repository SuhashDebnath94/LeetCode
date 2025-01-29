package linkedList;


public class N03_DeleteANodeFromALinkedList {
    /**
     * Given a node delete that node from the singly linked list.
     * You will just be given the node, not the head of the linkedlist
     *The Given node will never be the tail node.
     *
     * Explanation:
     *  Copy node.data=node.next.data to node
     *  and node.next=node.next.next
     *
     */

    /* Method to insert a node at
       the end of the linked list */
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

        Node<Integer> list1=new Node<>(5);
        addToTheLast(list1, new Node(10));
        addToTheLast(list1, new Node(15));


        System.out.println("Actual lists are: ");
        printList(list1);

        System.out.println("Result Linked List is:");
//        printList(list1);
    }


}
