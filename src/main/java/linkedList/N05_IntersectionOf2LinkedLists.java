package linkedList;

public class
N05_IntersectionOf2LinkedLists {

    /**
     * GIven two linked lists give the first point where both of them intersect
     *
     * Explanation:
     *      BEst optimal solution:
     *          Create 2 dummy nodes 1 and 2 pointing at the heads of each linked list
     *          Traverse them simultaneously
     *          The moment one reaches the end move it to the start of the other linked list
     *          so if dummy 1 is traversing list 1 if list1 exhausts then it will be moved to the start of list 2
     *
     *          Why do we do this?
     *              When dummy1 is moved to start of l2 then dummy 2 is at l1-l2 position
     *              then when dummy 2 is moved to start of l2 then both the nodes are aligned.
     *              Now when dummy1==dummy 2 then we have found the node we need
     *
     *              Draw for better understanding
     *
     *
     *         T= O(2M)
     *         S= O(1)
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

        Node<Integer> list1=new Node<>(2);
        addToTheLast(list1, new Node(5));
        addToTheLast(list1, new Node(6));
        addToTheLast(list1, new Node(1));

        Node<Integer> list2=new Node<>(3);
        addToTheLast(list2, new Node(9));
        addToTheLast(list2, new Node(1));


        System.out.println("Actual lists are: ");
        printList(list1);
        printList(list2);

        Node result= getIntersection(list1, list2);
//        Result should be 5-> 4-> 8
        System.out.println("Result Linked List is:");
        printList(result);
    }

    private static Node getIntersection(Node<Integer> headA, Node<Integer> headB) {
        if(headA==null || headB==null) return null;

        Node a=headA;
        Node b=headB;

        while (a!=b){
            a= a==null? headA: a.next; //if a is null it moves to the head of the second linked list if it is not null then it moves to the next node of a
            b= b==null? headB: b.next;
        }

        return a;
    }
}
