package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/29/16.
 */
public class Question100 {
    public static void main(String[] agrs) {
        int[] coins = new int[]{2};

        System.out.println(coinChange(coins, 3));
    }
    /**
     * Time - O(n ^2)
     */
    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        int[] dp = new int [amount+1];
        dp[0]=0; // do not need any coin to get 0 amount
        for(int i=1;i<=amount; i++)
            dp[i]= Integer.MAX_VALUE;

        for(int i=0; i<=amount; i++){
            for(int coin: coins){
                if(i+coin <=amount){
                    if(dp[i]==Integer.MAX_VALUE){
                        dp[i+coin] = dp[i+coin];
                    }else{
                        dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                    }
                }
            }
        }

        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

}
