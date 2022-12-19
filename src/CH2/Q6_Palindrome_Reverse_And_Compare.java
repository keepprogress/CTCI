package CH2;

import Library.LinkedListNode;

import static CH2.Q5_Sum_Lists_Follow_Up.createLinkedList;

public class Q6_Palindrome_Reverse_And_Compare {
    public static LinkedListNode cloneAndReverse(LinkedListNode node) {
        LinkedListNode head = null;
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while(one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        LinkedListNode head = createLinkedList(array);
        LinkedListNode reversed = cloneAndReverse(head);
        System.out.println(head.printForward());
        System.out.println(reversed.printForward());
        System.out.println(isEqual(head, reversed));

        int[] array2 = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 0};
        LinkedListNode head2 = createLinkedList(array2);
        LinkedListNode reversed2 = cloneAndReverse(head2);
        System.out.println(head2.printForward());
        System.out.println(reversed2.printForward());
        System.out.println(isEqual(head2, reversed2));
    }
}
