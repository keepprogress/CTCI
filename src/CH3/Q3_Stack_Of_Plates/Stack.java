package CH3.Q3_Stack_Of_Plates;

public class Stack {
    int capacity;
    Node top, bottom;
    int size = 0;
    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity && size != 0;
    }

    public void join(Node above, Node below) {
        if(above != null) above.below = below;
        if(below != null) below.above = above;
    }

    public boolean push(int value) {
        if(size >= capacity) return false;
        size++;
        Node n = new Node(value);
        if(size == 1) bottom = n;
        join(n,top);
        top = n;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if(bottom != null) bottom.below = null;
        size--;
        return b.value;
    }


}
