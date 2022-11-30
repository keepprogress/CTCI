package CH2;

import Library.LinkedListNode;

import static CH2.Q5_Sum_Lists_Follow_Up.createLinkedList;

public class Q6_Palindrome {

    //first come up method is to reverse the string and compare with the original string
    public static boolean isPalindromeV1(LinkedListNode node1) {
        LinkedListNode node2 = reverseLinkedList(node1);
        while(node1 != null && node2 != null) {
            if(node1.data != node2.data) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode head = null;
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode node3 = createLinkedList(new int[] {1,2,3,2,1});
        System.out.println(node3.printForward());
        System.out.println(reverseLinkedList(node3).printForward());
        System.out.println(isPalindromeV1(node3));

        LinkedListNode node4 = createLinkedList(new int[] {1,2,3,1,2,1});
        System.out.println(node4.printForward());
        System.out.println(reverseLinkedList(node4).printForward());
        System.out.println(isPalindromeV1(node4));
    }
}
