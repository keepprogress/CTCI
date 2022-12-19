package CH2;

import Library.LinkedListNode;

public class Q8_Loop_Detection {
    LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // stop when slow and fast collided
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }

        // error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // move slow to head
        slow = head;

        // move slow and fast at same speed
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
