package Queue;

import java.util.Stack;
public class N02_QueueUsingStack {

    /**
     *  * Queue:
     *  * offer(4)          4
     *  * offer(3)          3 4
     *  * offer(4)          2 3 4
     *  * poll()            2 3
     *  * peek()            3
     *  * <p>
     *  *
     *      Offer:
     *  *     1) Make 2 stacks
     *  *     3) add all elements of stack1 into stack2 one by one
     *  *     4) add element to add to stack 1
     *  *     5) add back all the elements of stack2 to stack1 one by one
     *      Poll:
     *          1) Pop Stack 1
     *       peek:
     *          1) Peek stack 1
     *
     *  * Stack 1:
     *  * 4
     *  * 4 3
     *  * 4 3 2
     *  * Stack 2:
     *  *  4
     *  *  4  3
     *  *
     *
     *  */
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Test the queue operations
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);

        System.out.println("Peek: " + queue.peek()); // Output: 2
        System.out.println("Poll: " + queue.poll()); // Output: 2
        System.out.println("Peek after poll: " + queue.peek()); // Output: 3
    }
}

class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Offer operation to add elements to the queue
    public void offer(int element) {
        // Move elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push the new element to stack1
        stack1.push(element);

        // Move elements back from stack2 to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Poll operation to remove and return the front element of the queue
    public int poll() {
        if (stack1.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack1.pop();
    }

    // Peek operation to return the front element without removing it
    public int peek() {
        if (stack1.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack1.peek();
    }
}
