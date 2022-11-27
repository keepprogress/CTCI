package CH2;

import Library.LinkedListNode;

import static CH2.Q5_Sum_Lists_Follow_Up.createLinkedList;

public class Q5_Sum_Lists {

    public static LinkedListNode sumLists(LinkedListNode listL, LinkedListNode listR, int carry) {
        if (listL == null && listR == null && carry == 0) {
            return null;
        }
        int sum = carry;

        sum += listL.data;

        sum += listR.data;

        LinkedListNode result = new LinkedListNode();

        result.data = sum % 10;

        if (listL.next != null && listR.next != null) {
            LinkedListNode more = sumLists(listL.next, listR.next, sum >= 10 ? 1 :0);
            result.setNext(more);
        }

        return result;
    }

    public static LinkedListNode createLinkedListLForSumList() {
        int [] listL = {7, 1, 6};
        return createLinkedList(listL);
    }

    public static LinkedListNode createLinkedListRForSumList() {
        int [] listR = {5, 9, 2};
        return createLinkedList(listR);
    }

    public static void main(String[] args) {
        LinkedListNode listL = createLinkedListLForSumList();
        LinkedListNode listR = createLinkedListRForSumList();

        LinkedListNode finalResult = sumLists(listL, listR, 0);
        System.out.println(finalResult.printForward());

    }
}
