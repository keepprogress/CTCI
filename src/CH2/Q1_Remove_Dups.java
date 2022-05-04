package CH2;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class Q1_Remove_Dups {
    /**
     * Requirement:
     *   Write code to remove duplicates from an unsorted linked list.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed
     */

    // Follow Up: Buffer Allowed

    void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while(n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    // Follow Up: No Buffer Allowed
    void deleteDups2(LinkedListNode head) {
        LinkedListNode current = head;
        while(current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }

            }
            current = current.next;
        }
    }

    /**
     * first thought:
     * 1. if temporary buffer is allowed then
     * use a hash table to check if each char is duplicated char(in hashtable)
     * then the
     * time complexity is O(N)
     * space complexity is O(N)
     *
     *
     * 2. if temporary buffer is not allowed then
     * use two pointer one faster pointer to check
     * if each char is duplicated char (same character with slow pointer)
     * then the time complexity is O(N^2)
     */
}
