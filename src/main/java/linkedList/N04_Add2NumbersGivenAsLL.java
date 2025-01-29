package linkedList;

public class N04_Add2NumbersGivenAsLL {
    /**
     * You will be give 2 numbers as linked list but in reverse order
     * Give the sum of those numbers in the same format
     *
     * Eg:
     *      2->5->6   is 652
     *      3->9->1 is  193
     *
     *      Sum is 845
     *      So result will be 5-> 4-> 8
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

        Node result= addNumbers_Striver(list1, list2);
//        Result should be 5-> 4-> 8
        System.out.println("Result Linked List is:");
        printList(result);
    }

    private static Node addNumbers(Node<Integer> list1, Node<Integer> list2) {

//        652
//       +193
//       ------
//        845

        Integer carry=0;

        Node<Integer> dummy=new Node<>();
        Node trav=dummy;

        while(list1!=null && list2!=null){

            Integer sum=0;

            sum=carry+sum+list1.data+list2.data;
            carry=0;

            carry=sum/10;
            sum = sum%10;

            trav.next=new Node<>(sum);
            trav=trav.next;

            list1=list1.next;
            list2=list2.next;
        }
        if(list1==null && list2==null){

        }
        else if(list1==null) {
            trav.next=list2;
        }
        else if(list2==null) trav.next=list1;

        return dummy.next;
    }

    private static Node addNumbers_Striver(Node<Integer> list1, Node<Integer> list2) {

//        652
//       +193
//       ------
//        845

        Integer carry=0;

        Node<Integer> dummy=new Node<>();
        Node trav=dummy;

        while(list1!=null || list2!=null || carry==1){

            Integer sum=0;

            if(list1!=null){
                sum+=list1.data;
                list1=list1.next;
            }
            if(list2!=null){
                sum+=list2.data;
                list2=list2.next;
            }
            sum+=carry;
            carry=sum/10;
            Node node=new Node<>(sum%10);
            trav.next=node;
            trav=trav.next;

        }
        return dummy.next;
    }
}
