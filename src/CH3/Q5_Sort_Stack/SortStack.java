package CH3.Q5_Sort_Stack;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            int temp = s.pop();
            while(!r.isEmpty() && r.peek() > temp){
                s.push(r.pop());
            }
            r.push(temp);
        }

        /** move all item back to s **/
        while(r.peek() < s.peek()) {
            s.push(r.pop());
        }
    }
}
