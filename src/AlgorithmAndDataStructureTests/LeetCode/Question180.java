package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/9/16.
 */
public class Question180 {
    public static void main(String[] agrs) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        System.out.println(isValidSerializationblag(s));
    }

    public static boolean isValidSerializationblag(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

}
