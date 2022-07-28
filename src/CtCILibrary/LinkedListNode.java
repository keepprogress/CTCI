package CtCILibrary;

public class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public LinkedListNode last;
    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        setNext(n);
        setPrevious(p);
        this.data = d;
    }

    public LinkedListNode(int d) {
        this.data = d;
    }

    public void setNext(LinkedListNode n) {
        this.next = n;
        if (this == last) {
            last = n;
        }
        if(n != null & this!=n.prev) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode p) {
        this.prev = p;
        if(p != null &&  this != p.next) {
            p.setNext(this);
        }
    }

    public String printForward() {
        if (next != null) {
            return "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if(next != null) {
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data, next2,null);
        return head2;
    }
}
