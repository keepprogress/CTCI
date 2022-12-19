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

    // when slow runner run k steps => the fast runner run 2k steps
    // and the fast runner is k steps into loop
    // if the circle length less than k
    // then the fast runner will run M * circle length + K = k steps
    // and that means slow runner are loop length - k steps away from each other
    // slow runner will catch 1 step closer each turn
    // slow runner will meet fast runner after loop length - K turns

    // after slow runner meet fast runner
    // the collided spot will be K steps before the loop start
    // (because slow runner already run away from the loop start length -K steps implies that length - K - K = 0)
    // it means that the collided spot is k steps long to the loop start

    // if we put slow runner back to head
    // and move slow and fast at same speed
    // then slow runner will meet fast runner at loop start after k steps
}
