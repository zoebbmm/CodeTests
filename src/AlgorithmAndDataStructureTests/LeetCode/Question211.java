package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question211 {
    public int evalRPN(String[] tokens) {
        // if empty or null
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                result = calculation(operand1, operand2, tokens[i]);

                // push back the intermediate results
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    private int calculation(int op1, int op2, String operator) {
        int result = 0;
        if (operator.equals("+")) {
            result = op1 + op2;
        } else if (operator.equals("-")) {
            result = op1 - op2;
        } else if (operator.equals("*")) {
            result = op1 * op2;
        } else if (operator.equals("/")) {
            result = op1 / op2;
        }
        return result;
    }
}
