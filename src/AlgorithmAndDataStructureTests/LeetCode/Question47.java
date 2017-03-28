package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/1/16.
 */
public class Question47 {
    public static void main(String[] agrs) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    public static int numDistinct(String S, String T) {
        if (S == null || S.length() == 0 || T == null) {
            return 0;
        }

        int[][] dp = new int[S.length() + 1][T.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= S.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[S.length()][T.length()];

    }

}
