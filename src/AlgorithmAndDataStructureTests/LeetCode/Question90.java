package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/20/16.
 */
public class Question90 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minIn = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minIn > maxProfit) {
                maxProfit = prices[i] - minIn;
            }

            if (prices[i] < minIn) {
                minIn = prices[i];
            }
        }

        return maxProfit;
    }
}
