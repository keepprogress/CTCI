package CH3.Q4_Queue_Via_Stacks;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int sizeQ (){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if(stackOldest.isEmpty()) {
            while(!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }
}
