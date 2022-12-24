package CH3.Q2_Stack_Min;

public class Question {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        System.out.println(stack.min()); // 5
        stack.push(6);
        System.out.println(stack.min()); // 5
        stack.push(3);
        System.out.println(stack.min()); // 3
        stack.push(7);
        System.out.println(stack.min()); // 3
        stack.pop();
        System.out.println(stack.min()); // 3
        stack.pop();
        System.out.println(stack.min()); // 5

        StackWithMin2 stack2 = new StackWithMin2();
        stack2.push(5);
        System.out.println(stack2.min()); // 5
        stack2.push(6);
        System.out.println(stack2.min()); // 5
        stack2.push(3);
        System.out.println(stack2.min()); // 3
        stack2.push(7);
        System.out.println(stack2.min()); // 3
        stack2.pop();
        System.out.println(stack2.min()); // 3
        stack2.pop();
        System.out.println(stack2.min()); // 5
    }
}
