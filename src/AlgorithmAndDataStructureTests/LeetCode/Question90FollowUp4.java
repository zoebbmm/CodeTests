package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/20/16.
 */
public class Question90FollowUp4 {
    public static void main(String[] agrs) {
        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

    public static int maxProfitblah(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int b1 = -prices[0];

        int s2 = 0;
        int s1 = 0;

        for (int i = 1; i <= prices.length; i++) {
            int b0 = Math.max(b1, s2 - prices[i - 1]);
            int s0 = Math.max(s1, b1 + prices[i - 1]);

            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s1;
    }
}
