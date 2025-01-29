package stack;

public class N01_ImplementationOfStackUsingArray {
    /**
     * peek
     * pop
     * push
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();

        stack.push(1);
        stack.printStack();
        stack.push(5);
        stack.printStack();
        System.out.println(stack.peek());
        stack.pop();
        stack.printStack();
        stack.push(7);
        stack.printStack();

    }
}

class Stack<T> {
    int size = 0;
    int actual_size;
    T[] arr = null;
    int currentPointer = 0;

    public Stack() {
        actual_size = 16;

        arr = (T[]) new Object[actual_size];
    }

    public int getSize() {
        return size;
    }

    public boolean push(T elem) {
        arr[currentPointer] = elem;
        currentPointer++;
        return true;
    }


    public T peek() {
        return arr[currentPointer - 1];
    }

    public boolean pop() {
        arr[currentPointer - 1] = null;
        currentPointer--;
        return true;
    }

    public void printStack() {
        int i = 0;
        while (arr[i] != null) {
            System.out.print(" " + arr[i] + " ");
            i++;
        }
        System.out.println(" ");
    }
}


