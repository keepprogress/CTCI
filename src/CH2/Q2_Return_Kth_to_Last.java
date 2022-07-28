package CH2;

import CtCILibrary.LinkedListNode;

public class Q2_Return_Kth_to_Last {
    /**
     * Requirement:
     * Implement an algorithm to find kth to last element of a single linked list.
     */
    public int findKthToLast(LinkedListNode head, int k) {
        if(head == null) {
            return 0;
        }
        int index = findKthToLast(head.next, k) + 1;
        if(index == k) {
            return head.data;
        }
        return 0;
    }

    /** findKthToLast will recursively stack call stack until the head is null
     * and the index is k. When the index is k, the head.data is returned.
     * If the index is not k, the head is passed to the next call.
     */


    //Implement an iterative algorithm to find kth to last element of a single linked list.
    public int findKthToLastIterative(LinkedListNode head, int k) {
        if(head == null) {
            return 0;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for(int i = 0; i < k; i++) {
            if(p2 == null) {
                return 0;
            }
            p2 = p2.next;
        }
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.data;
    }

    /**
     * findKthToLastIterative will move p2 to the kth node from the head.
     * Then move p1 and p2 simultaneously until p2 is null.
     * When p2 is null, p1 is the kth to last node.
     */



}
