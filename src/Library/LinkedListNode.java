package Library;

//create a class called LinkedListNode
public class LinkedListNode {
    //create a data field called data
    public int data;
    //create a data field called next
    public LinkedListNode next;
    //create a data field called prev
    public LinkedListNode prev;
    //create a data field called last
    public LinkedListNode last;
    //create a constructor that takes in an integer and a LinkedListNode
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        //set the data field to the integer passed in
        this.data = d;
        //set the next field to the LinkedListNode passed in
        this.next = n;
        //set the prev field to the LinkedListNode passed in
        this.prev = p;
        //set the last field to the LinkedListNode passed in
        this.last = n;
    }
    //create a constructor that takes in an integer
    public LinkedListNode(int d) {
        //set the data field to the integer passed in
        this.data = d;
        //set the next field to null
        this.next = null;
        //set the prev field to null
        this.prev = null;
        //set the last field to null
        this.last = null;
    }
    //create a method called setNext that takes in a LinkedListNode
    public void setNext(LinkedListNode n) {
        //set the next field to the LinkedListNode passed in
        this.next = n;
        //if the LinkedListNode passed in is not null and the next field is not the same as the next field of the LinkedListNode passed in
        if(n != null && this!=n.prev) {
            //set the next field of the LinkedListNode passed in to this
            n.setPrevious(this);
        }
        //set the last field to the LinkedListNode passed in
        this.last = n;
    }
    //create a method called
    public void setPrevious(LinkedListNode p) {
        //set the prev field to the LinkedListNode passed in
        this.prev = p;
        //if the LinkedListNode passed in is not null and the prev field is not the same as the prev field of the LinkedListNode passed in
        if(p != null && this!=p.next) {
            //set the prev field of the LinkedListNode passed in to this
            p.setNext(this);
        }
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                ", last=" + last +
                '}';
    }
}

