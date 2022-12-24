package CH3;

import Library.FullStackException;

import java.util.EmptyStackException;

public class Q1_Three_In_One_Flexible_Divisions {
    private class StackInfo {
        public int capacity, start, size;

        public StackInfo(int capacity, int start) {
            this.capacity = capacity;
            this.start = start;
        }
        /* Check if an index on the full array is within the stack boundaries
         * The stack can wrap around to the start of the array. */
        public boolean isWithinStackCapacity(int index) {
            if (index < 0 || index >= values.length) {
                return false;
            }

            /* If the index wraps around, adjust it. */
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

    }

    private StackInfo[] info;
    private int[] values;

    public Q1_Three_In_One_Flexible_Divisions(int numberOfStacks, int defaultSize) {
        /* Create metadata for all the stacks. */
        info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize, defaultSize * i);
        }
        values = new int[numberOfStacks * defaultSize];
    }

    /* Push value onto stack num, shifting/expanding stacks as necessary.
     * Throws exception if all stacks are full. */
    public void push(int stackNum, int value) throws FullStackException {
        if (allStacksAreFull()) {
            throw new FullStackException();
        }

        /* If the stack is full, expand it. */
        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        /* Find the index of the top element in the array + 1,
         * and increment the stack pointer. */
        stack.size++;
        values[stack.lastElementIndex()] = value;
    }

    /* Remove item from stack. */
    public int pop(int stackNum) {
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        /* Remove last element. */
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0; // Clear item
        stack.size--; // Shrink size
        return value;
    }

    /* Get top element of stack. */
    public int peek(int stackNum) {
        StackInfo stack = info[stackNum];
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return values[stack.lastElementIndex()];
    }

    /* Expand stack by shifting over other stacks. */
    /* Means that this stack will capacity++ and next stack capacity -- then move over elements. */
    public void expand(int stackNum) {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    public void shift(int stackNum) {
        System.out.println("/// Shifting " + stackNum);
        StackInfo stack = info[stackNum];

        /* If this stack is at its full capacity, then you need to move the next
         * stack over by one element. This stack can now claim the freed index. */
        if (stack.size >= stack.capacity) {
            shift((stackNum + 1 ) % info.length);
            stack.capacity++; // claim index that next stack lost
        }

        /* Shift all elements in stack over by one. */
        /* Because the shift function come from expand will shift to next stack
         * ,so when validating isWithinStackCapacity, the previous index end up cause
         * stack.isWithinStackCapacity(index) return false to prevent infinite loop
         * as the start won't be zero. */
        int index = stack.lastCapacityIndex();
        while(stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        /* Adjust stack data. */
        values[stack.start] = 0; // clear item.
        stack.start = nextIndex(stack.start); // move start.
        stack.capacity--; // shrink capacity.
    }

    /* Get index before this index, adjust for wrap around. */
    public int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    /* Get index after this index, adjust for wrap around. */
    public int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    /* Return true is all the stacks are full. */
    public boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    /* Returns the number of items actually present in stack. */
    public int numberOfElements() {
        int size = 0;
        for (StackInfo sd : info) {
            size += sd.size;
        }
        return size;
    }

    /* Adjust index to be within the range of 0 -> length - 1.*/
    public int adjustIndex(int index) {
        /* Java's mod operator can return neg values. For example, (-11 % 5) will
         * return -1 not 4 .We actually want the value to be 4. (since we're
         * wrapping around the index). */
        int max = values.length;
        return ((index % max) + max) % max;

    }
}
