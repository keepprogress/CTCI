package CH3.Q2_Stack_Min;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE; // Error value
        } else {
            return peek().min;
        }
    }
}
