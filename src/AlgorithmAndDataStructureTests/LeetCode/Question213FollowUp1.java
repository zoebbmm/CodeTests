package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question213FollowUp1 {
    /**
     * Space - O(1)
     *
     * Time - O(n)
     *
     * @param costs
     * @return
     */
    public int minCostIIConstantSpace(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);

        int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
        for(int i = 0; i<n; i++) {
            int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
            for(int j = 0; j<k;  j++) {
                int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
                if(minInd< 0) {min = val; minInd = j;}//when min isn't initialized
                else if(val < min) {//when val < min,
                    secMin = min;
                    min = val;
                    minInd = j;
                } else if(val < secMin) { //when min<=val< secMin
                    secMin = val;
                }
            }
            prevMin = min;
            prevMinInd = minInd;
            prevSecMin = secMin;
        }
        return prevMin;
    }


    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        // dp[j] means the min cost for color j
        int[] dp = new int[k];
        int min1 = 0;
        int min2 = 0;

        for (int i = 0; i < n; i++) {
            int oldMin1 = min1;
            int oldMin2 = min2;

            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                    dp[j] = oldMin1 + costs[i][j];
                } else {
                    dp[j] = oldMin2 + costs[i][j];
                }

                if (min1 <= dp[j]) {
                    min2 = Math.min(min2, dp[j]);
                } else {
                    min2 = min1;
                    min1 = dp[j];
                }
            }

        }

        return min1;
    }


}
