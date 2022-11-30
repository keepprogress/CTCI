package CH2;

import Library.LinkedListNode;

import java.util.Stack;

public class Q6_Palindrome_Iterative_Approch {
    public static boolean isPalindrome(LinkedListNode node) {
        LinkedListNode fast = node;
        LinkedListNode slow = node;

        Stack<Integer> stack = new Stack();
        // when fast standing at the bottom it will be not null and it's next = null
        // in the meantime slow will be on the middle
        while(fast != null && fast.next != null) {
            stack.push(slow.data);

            fast = fast.next.next;
            slow = slow.next;
        }

        // when the fast standing at the bottom and the LinkedListNode is odd,
        // skip middle element
        if(slow != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if(stack.pop().intValue() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // 1, 2, 1
    // slow = 1
    // fast = 1
    // slow = 2
    // fast = 1
}
