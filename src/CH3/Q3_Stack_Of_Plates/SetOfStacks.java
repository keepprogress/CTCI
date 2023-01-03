package CH3.Q3_Stack_Of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {
    public int capacity;
    public List<Stack> stacks = new ArrayList<>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        Stack last = getLastStack();
        if(last!=null && !last.isFull()){
            last.push(value);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    int pop() {
        Stack last = getLastStack();
        if(null==last) {
            throw new EmptyStackException();
        }
        int value = (int)last.pop();
        // if last stack is empty, remove it from stacks;
        if(last.size == 0) stacks.remove(stacks.size() -1);
        return value;
    }

    int popAt(int index) {
        return leftShift(index, true);
    }

    int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if(removeTop) {
            removed_item = (int)stack.pop();
        } else {
            removed_item = (int)stack.removeBottom();
        }
        if(stack.isEmpty()) {
            stacks.remove(index);
            // recurse until stacks.size() == index +1
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index+1, false);
            stack.push(v);
        }

        return removed_item;
    }

    Stack getLastStack() {
        if(stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size()-1);
    }
}
