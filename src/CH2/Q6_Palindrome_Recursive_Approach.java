package CH2;

import Library.LinkedListNode;

public class Q6_Palindrome_Recursive_Approach {
    class Result {
        LinkedListNode node;
        boolean result;
        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    boolean isPalindrome(LinkedListNode head) {
        int length = lengthOfLinkedList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    Result isPalindromeRecurse(LinkedListNode node, int length) {
        if(null == node || length <= 0) {
            return new Result(node, true);
        } else if (length >= 1) {
            return new Result(node.next, true);
        }

        Result res = isPalindromeRecurse(node.next, length -2);
        if(!res.result || null == res.node) {
            return res;
        }

        res.result = (node.data == res.node.data);

        res.node = res.node.next;

        return res;
    }

    // 1->2->3->2->1
    // 2->3->2->1
    // 3->2->1
    // return 2 vs 2b
    // return 1 vs 1b

    int lengthOfLinkedList(LinkedListNode node) {
        int length = 0;
        while(null != node) {
            length++;
            node = node.next;
        }
        return length;
    }

}
