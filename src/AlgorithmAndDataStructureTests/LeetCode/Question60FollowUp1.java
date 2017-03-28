package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question60FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        System.out.println(jump(nums));

        int[] nums1 = new int[]{2, 3, 1, 1, 0, 1};

        System.out.println(jump(nums1));

        int[] nums2 = new int[]{2, 3, 1, 1, 1, 2};

        System.out.println(jump(nums2));

    }
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lastReach = 0;
        int reach = 0;
        int step = 0;

        for (int i = 0; i <= reach && i < nums.length; i++) {
            //when last jump can not read current i, increase the step by 1
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            //update the maximal jump
            reach = Math.max(reach, nums[i] + i);
        }

        if (reach < nums.length - 1)
            return 0;

        return step;
    }

    /**
     * It is natural to think about a DP solution. We can use an array dp[A.length], where dp[i] means the minimum steps from the first element to i. So we only need to check the dp[n - 1].
     *
     * Discussion:
     * The solution of DP has time complexity of O(n^2).
     * @param A
     * @return
     */
    public int jumpSolution2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int[] dp = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < A.length; i++) {
            int maxReach = Math.min(A[i] + i, A.length - 1);
            for (int j = i + 1; j <= maxReach; j++) {
                if (dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        return dp[A.length - 1];
    }
}
