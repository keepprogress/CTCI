package CH2;

import CtCILibrary.LinkedListNode;

public class Q3_Delete_Middle_Node {
    //Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
    //EXAMPLE
    //Input: the node c from the linked list a->b->c->d->e->f
    //Result: nothing is returned, but the new linked list looks like a->b->d->e->f
    public void deleteMiddleNode(LinkedListNode node) {
        if(node == null || node.next == null) {
            return;
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
    }
    /**
     * deleteMiddleNode will delete the node after the node passed in.
     * The node before the node passed in will pont next to the node after the node passed in.
     * The node after the node passed in will point to the node after the node after the node passed in.
     */


}
