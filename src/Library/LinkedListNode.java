package Library;

//create a class called LinkedListNode
public class LinkedListNode {

    public LinkedListNode next, prev, last;

    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        //set the data field to the integer passed in
        this.data = d;
        setNext(n);
        setPrevious(p);
    }

    public LinkedListNode(int d) {
        this.data = d;
    }

    public LinkedListNode() {}

    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null
                && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode p) {
        prev = p;
        if(p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if(next != null) {
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }

    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }
}

