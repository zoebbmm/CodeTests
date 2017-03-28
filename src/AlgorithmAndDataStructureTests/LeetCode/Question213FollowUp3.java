package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question213FollowUp3 {
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= len-2; i++) dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        int res = dp[len-2];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i <= len-1; i++) dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        return Math.max(res, dp[len-1]);
    }
}
