package AlgorithmAndDataStructureTests.LeetCode.Question118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 10/31/16.
 */
public class MinStack {
    private List<Integer> stack = new ArrayList<Integer>();
    private List<Integer> min = new ArrayList<Integer>();

    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() || x <= min.get(min.size() - 1)) {
            min.add(x);
        }
    }

    public void pop() {
        int removed = stack.remove(stack.size() - 1);
        if (removed == min.get(min.size() - 1)) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}
