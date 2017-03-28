package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/2/16.
 */
public class Question98FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = {1, 101, 2, 3, 100, 4, 5};

        System.out.println(maxSumIncreasingSubsequence(nums));
    }

    public static int maxSumIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        int maxSum = 0;

        for(int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (dp[i] < (dp[j] + nums[i]))) {
                    dp[i] = dp[j] + nums[i];
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
