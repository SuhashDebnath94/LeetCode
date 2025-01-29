package Practice;

import linkedList.Node;

public class DoublyLinkedList<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data.toString() +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = head.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T elem){
        if(isEmpty()) head = tail = new Node<>(elem, null, null);
        else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }



}
