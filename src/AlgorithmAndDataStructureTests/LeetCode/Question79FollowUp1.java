package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question79FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(isValid("([]){({})}"));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
