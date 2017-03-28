package AlgorithmAndDataStructureTests.chapter3;

import java.util.Stack;

/**
 * Created by weizhou on 7/3/16.
 */
public class Question6 {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();

        while (!stack.isEmpty()) {
            int top = stack.pop();

            while (!buffer.isEmpty() && (top < buffer.peek())) {
                int temp = buffer.pop();

                stack.push(temp);
            }

            buffer.push(top);
        }
    }
}
