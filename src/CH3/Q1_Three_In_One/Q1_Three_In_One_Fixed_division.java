package CH3.Q1_Three_In_One;

import Library.FullStackException;

import java.util.EmptyStackException;

public class Q1_Three_In_One_Fixed_division {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public Q1_Three_In_One_Fixed_division(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) throws FullStackException {
        /* Check that we have space for the next element */
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        /* Increment stack pointer and then update top value. */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // Get top
        values[topIndex] = 0; // Clear
        sizes[stackNum]--; // Shrink
        return value;
    }

    /* Return top element */
    public int peek(int stackNum) {
        if(isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    /* Return true if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Return true if stack is empty. */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Return index of the top of the stack. */
    /* Because the index is count from 0 -> 2 when stack number is 3,
     * the offset is the start line of stack 3. We can add size -1 to get the last element's index. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
