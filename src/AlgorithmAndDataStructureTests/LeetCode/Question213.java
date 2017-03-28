package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question213 {
    /**
     * Time - O(n)
     * Space - O(n)
     *
     * @param costs
     * @return
     */
    public int minCostSolution1(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }

    /**
     * Time - O(n)
     * Space - O(n)
     *
     * @param costs
     * @return
     */
    public int minCostSolution2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int[] prev = new int[3];
        int[] curr = new int[3];

        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            curr[0] = Math.min(prev[1], prev[2]) + costs[i][0];
            curr[1] = Math.min(prev[0], prev[2]) + costs[i][1];
            curr[2] = Math.min(prev[0], prev[1]) + costs[i][2];

            // update the curr
            prev[0] = curr[0];
            prev[1] = curr[1];
            prev[2] = curr[2];
        }

        return Math.min(Math.min(prev[0], prev[1]), prev[2]);
    }

    /**
     * Space - O(1)
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}
