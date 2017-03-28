package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question86FollowUp6 {
    public static void main(String[] agrs) {
        System.out.println(numSquares(7));
    }
    public static int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
