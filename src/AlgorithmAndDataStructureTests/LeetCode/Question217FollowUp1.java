package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question217FollowUp1 {
    public static void main(String[] agrs) {
        String s = "1+4+5*2-3+6/2";

        System.out.println(calculate(s));

        String s3 = "12-1";

        System.out.println(calculate(s3));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String delim = "[ ]+";
        s = s.replaceAll(delim, "");

        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();

        int i = 0;
        while (i < s.length()) {
            char token = s.charAt(i);
            if (isNumber(token)) {
                StringBuffer sb = new StringBuffer();
                while (i < s.length() && isNumber(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                int val = Integer.valueOf(sb.toString());
                numStack.push(val);
            } else {
                if (opStack.isEmpty() || !hasHigherPrecedence(opStack.peek(), token)) {
                    opStack.push(token);
                    i++;
                } else {
                    calculate(numStack, opStack);
                }
            }
        }

        while(!opStack.isEmpty()) {
            calculate(numStack, opStack);
        }

        return numStack.pop();
    }

    private static boolean isNumber(char character) {
        return character >= '0' && character <= '9';
    }

    private static void calculate(Stack<Integer> numStack, Stack<Character> opStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char oprator = opStack.pop();

        int result = 0;

        switch(oprator) {
            case '+' : result = num1 + num2;
                break;

            case '-' : result = num1 - num2;
                break;

            case '*' : result = num1 * num2;
                break;

            case '/' : result = num1 / num2;
                break;
        }

        numStack.push(result);
    }

    private static boolean hasHigherPrecedence(char str1, char str2) {
        if (str1 == '*'|| str1 == '/') {
            return true;
        }

        if ((str1 == '+' || str1 == '-') && (str2 == '+' || str2 == '-')) {
            return true;
        }

        return false;
    }
}
