package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question4 {
    public String countAndSay(int n) {
        if (n < 0) {
            return "";
        }

        String s = "1";

        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            int j = 0;
            while (j < s.length()) {
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(Integer.toString(count));
                sb.append(s.charAt(j));
                count = 1;
                j++;
            }

            s = sb.toString();
        }

        return s;
    }
}
