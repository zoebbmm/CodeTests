package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question207 {
    public int numWays(int n, int k) {
        int dp[] = {0, k , k*k, 0};

        if(n <= 2)
            return dp[n];

        for(int i = 2; i < n; i++){
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }

    /**
     * Constance Space Solution
     *
     * @param n
     * @param k
     * @return
     */
    public int numWaysConstantSpace(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }
}
