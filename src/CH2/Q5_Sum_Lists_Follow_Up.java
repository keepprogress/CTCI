package CH2;

import Library.LinkedListNode;

public class Q5_Sum_Lists_Follow_Up {

    static class PartialSum {
        LinkedListNode sum = null;
        int carry = 0;
    }

    public static int length(LinkedListNode list) {
        if(list == null) {
            return 0;
        }
        return 1 + length(list.next);
    }

    static LinkedListNode addLists(LinkedListNode listL, LinkedListNode listR) {
        int lenL = length(listL);
        int lenR = length(listR);

        if (lenL < lenR) {
            listL = padList(listL, lenR - lenL);
        } else {
            listR = padList(listR, lenL - lenR);
        }

        PartialSum sum = addListsHelper(listL, listR);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    public static LinkedListNode padList(LinkedListNode list, int padding) {
        LinkedListNode head = list;
        for (int i = 0; i < padding; i++) {
            LinkedListNode n = new LinkedListNode(0, null, null);
            head.prev = n;
            n.next = head;
            head = n;
        }
        return head;
    }

    public static PartialSum addListsHelper (LinkedListNode listL, LinkedListNode listR) {
        // recursion stop condition
        if (listL == null && listR == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        // add smaller digits recursively
        PartialSum sum = addListsHelper(listL.next, listR.next);

        // add carry to current node
        // because the recursion is from the end to the beginning
        // so add carry after the final call stack pop
        int val = sum.carry + listL.data + listR.data;

        // insert sum of current digits
        LinkedListNode full_result = insertBefore(sum.sum, val % 10);

        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    public static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        node.next = list;
        return node;
    }

    public static LinkedListNode createLinkedListLForSumListFollowUp() {
        int [] listL = {1,2,3,4};

        return createLinkedList(listL);
    }

    public static LinkedListNode createLinkedListRForSumListFollowUp() {
        int [] listR = {5,6,7};

        return createLinkedList(listR);
    }

    static LinkedListNode createLinkedList(int[] listL) {
        LinkedListNode head = new LinkedListNode(listL[0], null, null);
        LinkedListNode current = head;
        for (int i=1; i<listL.length; i++) {
            current = new LinkedListNode(listL[i], null, current);
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode listL = createLinkedListLForSumListFollowUp();
        LinkedListNode listR = createLinkedListRForSumListFollowUp();

        LinkedListNode finalResult = addLists(listL, listR);
        System.out.println(finalResult.printForward());

    }
}
