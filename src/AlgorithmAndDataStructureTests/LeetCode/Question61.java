package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question61 {
    public static void main(String[] agrs) {
        System.out.println(numDecodings("123"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(s);
        if (num >= 1 && num <= 26) {
            return true;
        }

        return false;
    }
}
