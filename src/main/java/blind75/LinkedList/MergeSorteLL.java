package blind75.LinkedList;

public class MergeSorteLL {

    public static Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data > l2.data) {
//            if first value of l1 is greater than first value of l2 then swap
//            so that always first value of l1 is smaller than l2
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        System.out.println("Post swapping lists are: ");
        printList(l1);
        printList(l2);

        Node result = l1;

        System.out.println("Result is now equals l1 and is: ");
        printList(result);

        while (l1 != null && l2 != null) {
            System.out.println("both lists are not null");
            Node temp = null;
            while (l1 != null && l1.data <= l2.data) {
                System.out.println("List1 is not null and list1 element is less than list 2 element");
                temp = l1;
                System.out.println("Temp is now list 1 and is currently: ");
                printList(temp);

                l1 = l1.next;
                System.out.println("List1 head is now moved to the next element and is now");
                printList(l1);

                System.out.println("Result is : ");
                printList(result);
                System.out.println(" ");

                System.out.println("l1 is : ");
                printList(l1);
                System.out.println(" ");

                System.out.println("l2 is : ");
                printList(l2);
                System.out.println(" ");

            }
            temp.next = l2;
            System.out.println("The elements of l2 are added to temp and temp is: ");
            printList(temp);

            System.out.println("Result is : ");
            printList(result);

            System.out.println(" ");System.out.println("l1 is : ");
            printList(l1);
            System.out.println(" ");

            System.out.println("l2 is : ");
            printList(l2);
            System.out.println(" ");
//            swap
            Node temp2 = l1;
            l1 = l2;
            l2 = temp2;
            System.out.println("Again swapping l1 ad l2 the results are");

            System.out.println("Result is : ");
            printList(result);
            System.out.println(" ");

            System.out.println("l1 is : ");
            printList(l1);
            System.out.println(" ");

            System.out.println("l2 is : ");
            printList(l2);
            System.out.println(" ");
        }
        return result;
    }

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
        Node<Integer> list2=new Node<>(2);

        addToTheLast(list1, new Node(10));
        addToTheLast(list1, new Node(15));

        addToTheLast(list2, new Node(3));
        addToTheLast(list2, new Node(20));

        System.out.println("Actual lists are: ");
        printList(list1);
        printList(list2);

        list1 = merge_prac(list1, list2);


        System.out.println("Result Linked List is:");
        printList(list1);
    }

    public static Node<Integer> merge_prac(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data > l2.data) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node res = l1;

        while (l1 != null && l2 != null) {
            Node temp = null;
            while (l1 != null && l1.data <= l2.data) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            Node temp1 = l1;
            l1 = l2;
            l2 = temp1;
        }

        return res;
    }
}
