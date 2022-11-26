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
//            current.next = null;
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

    public static LinkedListNode partition3(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null) {
            LinkedListNode next = node.next;
            if(node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static LinkedListNode createLinkedList() {
        /* Create linked list */
        int[] vals = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }

    public static void main(String[] args) {

        System.out.println(createLinkedList().printForward());

        LinkedListNode H3 = partition3(createLinkedList(), 5);

        System.out.println(H3.printForward());
    }
}
