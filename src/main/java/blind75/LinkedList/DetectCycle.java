package blind75.LinkedList;

import java.util.HashSet;

public class DetectCycle {


    //utility function to insert node in the list
        static ListNode insertNode(ListNode head, int val) {
            ListNode newNode = new ListNode(val);

            if(head == null) {
                head = newNode;
                return head;
            }

            ListNode temp = head;
            while(temp.next != null) temp = temp.next;

            temp.next = newNode;
            return head;
        }

        //utility function to create cycle
        static void createCycle(ListNode head, int a, int b) {
            int cnta = 0,cntb = 0;
            ListNode p1 = head;
            ListNode p2 = head;
            while(cnta != a || cntb != b) {
                if(cnta != a)
                {p1 = p1.next; ++cnta;}
                if(cntb != b)
                {p2 = p2.next; ++cntb;}
            }
            p2.next = p1;
        }

        //utility function to detect cycle

//    We can use the below method OR:
//        1) we can have a visited boolean flag in node structure and if that is true for any traversal we have a cycle.
//        2) We can use floyd's algorithm where we have 2 pointers fast and slow. we increment fast by 2 steps and slow by 1 step and if at any point fast.next is equals slow then we have a cycle'
        static boolean cycleDetect(ListNode head) {
            HashSet<ListNode> hashTable=new HashSet<>();
            while(head != null) {
                if(hashTable.contains(head)) return true;
                hashTable.add(head);
                head = head.next;
            }
            return false;
        }

        public static void main(String args[]) {
            ListNode head = null;
            head = insertNode(head, 1);
            head = insertNode(head, 2);
            head = insertNode(head, 3);
            head = insertNode(head, 4);
            createCycle(head, 1, 3);//creating cycle in the list
            if (cycleDetectOptimal(head) == true)
                System.out.println("Cycle detected");
            else
                System.out.println("Cycle not detected");
        }

    private static boolean cycleDetectOptimal(ListNode head) {
            if(head==null || head.next==null) return  false;

            ListNode fast=head;
            ListNode slow=head;

            while (fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    return true;
                }
            }
            return false;
    }

    private static ListNode cycleDetectOptimalAndReturnStartingNodeOFCycle(ListNode head) {
        if(head==null || head.next==null) return  null;

        ListNode fast=head;
        ListNode slow=head;
        ListNode entry=head;

        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                while(slow!=entry){
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }
        return null;
    }


}
