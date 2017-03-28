package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question234 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return result;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String s1 = s.substring(0, i);
                String s2 = "--";
                String s3 = s.substring(i + 2);
                String temp = s1 + s2 + s3;
                result.add(temp);
            }
        }

        return result;
    }
}
