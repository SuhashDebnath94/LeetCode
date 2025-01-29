package linkedList;

public class N06_FindIFLinkedListIsPalindromic {
    /**
     * Given a linked list find if it is palindromic
     *
     * Explanation:
     *  Find middle of the linked list
     *  From middle.next reverse the linkedlist and store in list 2
     *  match the elements of list 2 to elements of list 1
     *
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
        addToTheLast(list1, new Node(5));
        addToTheLast(list1, new Node(5));
        addToTheLast(list1, new Node(2));


        System.out.println("Actual list is: ");
        printList(list1);

        Boolean result= isPalindromic(list1);
//        Result should be 5-> 4-> 8
        System.out.println("Result is: "+result);
    }

    private static Boolean isPalindromic(Node<Integer> list1) {

        Node middleNode=getMiddleNode(list1);
        Node list2=middleNode.next;
        list2=reverseLL(list2);

        while(list2!=null){
            if(list2.data!=list1.data) return false;
            list2=list2.next;
            list1=list1.next;
        }

        return true;

    }

    private static Node reverseLL(Node head) {
        Node trav=null;

        while(head!=null){
            Node next=head.next;
            head.next=trav;
            trav=head;
            head=next;
        }
        return trav;
    }

    public static Node<Integer> getMiddleNode(Node<Integer> head){

        Node slow= head;
        Node fast= head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next; // move the fast pointer by 2
            slow=slow.next; // move the slow pointer by 1
        }

        return slow;
    }

}
