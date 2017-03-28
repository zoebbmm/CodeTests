package AlgorithmAndDataStructureTests.LeetCode.Question53FollowUp1;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator{
    Stack<Iterator<NestedInteger>> stack;
    Integer top;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
        top = null;
    }

    @Override
    public Integer next() {
        Integer result = null;
        if (top != null) {
            result = top;
            top = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        if (top != null) {
            return true;
        }

        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (it.hasNext()) {
                NestedInteger curr = it.next();
                if (curr.isInteger()) {
                    top = curr.getInteger();
                    return true;
                } else {
                    stack.push(curr.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }

        return false;
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
