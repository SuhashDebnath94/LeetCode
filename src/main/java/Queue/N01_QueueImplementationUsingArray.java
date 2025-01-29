package Queue;

public class N01_QueueImplementationUsingArray {

    /**
     * peek
     * pop
     * push
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();

        queue.push(1);
        queue.printStack();
        queue.push(5);
        queue.printStack();
        System.out.println(queue.peek());
        queue.pop();
        queue.printStack();
        queue.push(7);
        queue.printStack();
        queue.pop();
        queue.printStack();

    }
}

class Queue<T> {
    int size = 0;
    int actual_size;
    T[] arr = null;
    int currentPointer = 0;

    int tail=0;

    public Queue() {
        actual_size = 16;

        arr = (T[]) new Object[actual_size];
    }

    public int getSize() {
        return size;
    }

    public boolean push(T elem) {
        arr[currentPointer] = elem;
        currentPointer++;
        size++;
        return true;
    }


    public T peek() {
        return arr[tail];
    }

    public boolean pop() {
        arr[tail] = null;
        tail++;
        size--;
        return true;
    }

    public void printStack() {
        int i = tail;
        while (arr[i] != null) {
            System.out.print( arr[i] + " ");
            i++;
        }
        System.out.println(" ");
    }
}