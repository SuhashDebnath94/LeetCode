package stack;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class N02_ImplementStackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(5);
        stack.push(7);

        stack.printStack();

        stack.pop();
        stack.printStack();
        System.out.println(stack.peek());

    }
}

/**
 * Stack:
 * push(1)          1
 * push(5)             1 5
 * push(7)          1 5 7
 * pop()            1 5
 * peek()           5
 * <p>
 *
 *     1) Make 2 Queues
 *     2) If q1 is empty add in q1 and return
 *     3) else add in q2
 *     4) add all elements of q1 into q2 one by one
 *     5) add back all the elements of q2 to q1 one by one
 * Queue 1:
 * 1
 * 5 1
 * 7 5 1
 * Queue 2:
 * null
 * 5 1
 * 7 5 1
 */

class StackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new ArrayBlockingQueue(16);
        q2 = new ArrayBlockingQueue(16);
    }

    public Boolean push(Integer elem) {
        if (q1.size() == 0) {
            q1.offer(elem);
            return true;
        } else {
            q2.offer(elem);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            return true;
        }
    }

    public Boolean pop() {
        if (q1.size() == 0) {
            System.out.println("Stack is empty");
            return false;
        }
        q1.poll();
        return true;
    }

    public Integer peek() {
        if (q1.size() == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.poll();
    }

    public void printStack() {
        Queue temp =  new ArrayBlockingQueue(16);
        Queue temp1 =  new ArrayBlockingQueue(16);
        temp.addAll(q1);
//        while(!temp.isEmpty()){
//            temp1.offer(temp.poll());
//        }
//        while (temp1.size() != 0) {
//            System.out.print(temp1.poll() + " ");
//        }
        while (temp.size() != 0) {
            System.out.print(temp.poll() + " ");
        }

        System.out.println(" ");
    }
}