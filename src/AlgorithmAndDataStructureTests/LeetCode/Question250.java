package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 10/29/16.
 */
public class Question250 {
    public static void main(String[] agrs) {
        List<String> result = addOperators("123", 6);

        for (String str : result) {
            System.out.println(str);
        }

        List<String> result1 = addOperators("232", 8);

        for (String str : result1) {
            System.out.println(str);
        }

        List<String> result2 = addOperators("105", 5);

        for (String str : result2) {
            System.out.println(str);
        }

        List<String> result3 = addOperators("00", 0);

        for (String str : result3) {
            System.out.println(str);
        }
    }
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;

    }
    public static void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long currentSum, long prevNum) {
        if(pos == num.length()) {
            if(target == currentSum) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, currentSum + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, currentSum - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, currentSum - prevNum + prevNum * curr, prevNum * curr);
                sb.setLength(len);
            }
        }
    }
}
