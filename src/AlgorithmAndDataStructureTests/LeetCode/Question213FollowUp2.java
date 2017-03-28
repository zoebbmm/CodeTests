package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question213FollowUp2 {
    public static void main(String[] agrs) {
        System.out.println(rob(new int[]{1, 3, 8, 4}));
    }
    /**
     * Time - O(n)
     * Space - O(n)
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public static int robSolutionV2(int[] nums) {
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        // a是上次的最大收益
        int a = nums[0];
        // b是当前的最大受益
        int b = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int tmp = b;
            // 当前的最大收益是两种选择里较大的那个
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }
}
