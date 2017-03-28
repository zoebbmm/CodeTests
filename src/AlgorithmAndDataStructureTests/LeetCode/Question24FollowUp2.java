package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 9/23/16.
 */
public class Question24FollowUp2 {
    public static void main(String[] agrs) {
        System.out.println(DeleteDigits("14322189", 3));

        System.out.println(DeleteDigits("1432219", 3));
        System.out.println(DeleteDigits("10200", 1));
        System.out.println(DeleteDigits("10", 2));

    }
    public static String DeleteDigits(String A, int k) {
        if (A == null || A.length() < k) return null;
        if (A.length() == k) return "0";

        Stack<Integer> stack = new Stack<Integer>();
        int deleted = 0;
        for (int i = 0; i < A.length(); i++) {
            int cur = A.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > cur && deleted < k) {
                stack.pop();
                deleted++;
            }
            stack.push(cur);
        }

        while (deleted < k) {
            stack.pop();
            deleted++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        while (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
