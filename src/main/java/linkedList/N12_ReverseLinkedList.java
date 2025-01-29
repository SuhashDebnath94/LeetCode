package linkedList;


public class N12_ReverseLinkedList {
    public static void main(String[] args) {

    }

    public Node<Integer> reverse(Node<Integer> head){

        Node<Integer> trav=null;

        while(head !=null){
            Node<Integer> next=head.next;
            head.next=trav;
            trav=head;
            head=next;
        }

        return trav;
    }
}
