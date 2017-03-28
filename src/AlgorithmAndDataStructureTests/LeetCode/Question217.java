package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question217 {
    public static void main(String[] agrs) {
        String s = "(1+(4+5*2)-3)+(6/2)";

        System.out.println(calculate(s));

        String s1 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(calculate(s1));

        String s2 = " 2-1 + 2 ";

        System.out.println(calculate(s2));

        String s3 = "12-1";

        System.out.println(calculate(s3));
    }
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // parse the string
        String delim = "[ ]+";
        s = s.replaceAll(delim, "");

        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();

        int i = 0;

        while(i < s.length()) {
            char elem = s.charAt(i);
            if (Character.isDigit(elem)) {
                // To number
                int num = elem - '0';
                int j = i + 1;

                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                numStack.push(num);
                i = j;
            } else { // Operator
                if (opStack.isEmpty()) {
                    opStack.push(elem);
                } else if (elem == '*' || elem == '/') {
                    char top = opStack.peek();
                    if (top == '(') {
                        opStack.push(elem);
                    } else if (top == '+' || top == '-') {
                        opStack.push(elem);
                    } else {
                        compute(numStack, opStack);
                        opStack.push(elem);
                    }
                } else if (elem == '+' || elem == '-') {
                    char top = opStack.peek();
                    if (top == '(') {
                        opStack.push(elem);
                    } else {
                        compute(numStack, opStack);
                        opStack.push(elem);
                    }
                } else if (elem == '(') {
                    opStack.push(elem);
                } else if (elem == ')') { // Right ")"
                    while ((!opStack.isEmpty()) && (opStack.peek() != '(')) {
                        compute(numStack, opStack);
                    }
                    opStack.pop();
                }
                i++;
            }
        }

        while (!opStack.isEmpty()) {
            compute(numStack, opStack);
        }

        return numStack.pop();
    }

    private static void compute(Stack<Integer> numStack, Stack<Character> opStack) {

        if (numStack.size() < 2) {
            while (!opStack.isEmpty()) {
                opStack.pop();
            }
            return;
        }

        int num2 = numStack.pop();
        int num1 = numStack.pop();

        char op = opStack.pop();
        int ans = 0;

        switch(op) {
            case '+': ans = num1 + num2;
                break;

            case '-': ans = num1 - num2;
                break;

            case '*': ans = num1 * num2;
                break;

            case '/': ans = num1 / num2;
                break;
        }

        numStack.push(ans);
    }
}
