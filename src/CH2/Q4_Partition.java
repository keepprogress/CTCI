package CH2;

import Library.LinkedListNode;

public class Q4_Partition {

    //Write code to partition a linked list around a value x,
    // such that all nodes less than x come before all nodes greater than or equal to x.
    //If x is contained within the list,
    // the values of x only need to be after the elements less than x (see below).
    //The partition element x can appear anywhere in the "right partition";
    // it does not need to appear between the left and right partitions.
    //EXAMPLE
    //Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
    //Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    public static LinkedListNode partition(LinkedListNode head, int partition) {
        LinkedListNode less = null;
        LinkedListNode lessTail = null;
        LinkedListNode greater = null;
        LinkedListNode greaterTail = null;
        LinkedListNode current = head;
        while(current != null) {
            LinkedListNode next = current.next;
            if(current.data < partition) {
                if(less == null) {
                    less = current;
                    lessTail = less;
                } else {
                    lessTail.next = current;
                    lessTail = lessTail.next;
                }
            } else {
                if(greater == null) {
                    greater = current;
                    greaterTail = greater;
                } else {
                    greaterTail.next = current;
                    greaterTail = greaterTail.next;
                }
            }
            current = next;
        }
        if(lessTail != null) {
            lessTail.next = greater;
        }
        if(greaterTail != null) {
            greaterTail.next = null;
        }
        if(less == null) {
            return greater;
        } else {
            return less;
        }
    }

    public static LinkedListNode partition2(LinkedListNode head, int partition) {
        LinkedListNode less = null;
        LinkedListNode lessTail = null;
        LinkedListNode greater = null;
        LinkedListNode greaterTail = null;
        LinkedListNode current = head;
        while(current != null) {
            if(current.data < partition) {
                if(null==less) {
                    less = current;
                    lessTail = less;
                } else {
                    lessTail.next = current;
                    lessTail = lessTail.next;
                }
            } else {
                if(null==greater) {
                    greater = current;
                    greaterTail = greater;
                } else {
                    greaterTail.next = current;
                    greaterTail = greaterTail.next;
                }
            }
            current = current.next;
        }
        if(lessTail != null) {
            lessTail.next = greater;
        }
        if(greaterTail != null) {
            greaterTail.next = null;
        }
        if(less != null) {
            return less;
        } else {
            return greater;
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3, null, null);
        head.next = new LinkedListNode(5, null, null);
        head.next.prev = head;
        head.next.next = new LinkedListNode(8, null, null);
        head.next.next.prev = head.next;
        head.next.next.next = new LinkedListNode(5, null, null);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new LinkedListNode(10, null, null);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new LinkedListNode(2, null, null);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new LinkedListNode(1, null, null);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        LinkedListNode newNode = partition2(head, 5);

        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.next;
        }

    }
}
