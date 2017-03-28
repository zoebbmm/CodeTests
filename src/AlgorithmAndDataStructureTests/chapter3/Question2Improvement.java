package AlgorithmAndDataStructureTests.chapter3;

import java.util.Stack;

/**
 * Created by weizhou on 7/3/16.
 */
public class Question2Improvement extends Stack<Integer>{
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if (value < min()) {
            minStack.push(value);
        }

        this.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minStack.pop();
        }

        return value;
    }

    private int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
