package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/26/16.
 */
public class Question51FollowUp5 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));

        int[] nums1 = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(nums1));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        sum /= 2;
        // dp def
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[sum];
    }
}
