package AlgorithmAndDataStructureTests.LeetCode;

import java.util.*;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question79FollowUp3 {
    public static void main(String[] agrs) {
        List<String> result = removeInvalidParentheses("(a)())");

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    public static boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')  {
                count++;
            }
            if (c == ')') {

                if (count != 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }

        return count == 0;
    }

    static ArrayList<String> result = new ArrayList<String>();
    static int max=0;

    public static List<String> removeInvalidParenthesesblah(String s) {
        if(s==null)
            return result;

        dfs(s, "", 0, 0);
        if(result.size()==0){
            result.add("");
        }

        return result;
    }

    public static void dfs(String left, String right, int countLeft, int maxLeft){
        if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                if(maxLeft > max){
                    max = maxLeft;
                }

                if(maxLeft==max && !result.contains(right)){
                    result.add(right);
                }
            }

            return;
        }

        if(left.charAt(0)=='('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }else if(left.charAt(0)==')'){
            if(countLeft>0){
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
            }

            dfs(left.substring(1), right, countLeft, maxLeft);

        }else{
            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
        }
    }


}
