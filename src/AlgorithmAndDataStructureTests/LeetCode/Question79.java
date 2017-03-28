package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question79 {
    public static void main(String[] agrs) {
        System.out.println(longestValidParentheses("((()))"));
        System.out.println(longestValidParentheses(")()())"));


    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - start + 1);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }

        return max;
    }
}
