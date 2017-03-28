package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/6/16.
 */
public class Question143FollowUp3 {
    public static void main(String[] agrs) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxContiguousSum(nums));
    }

    public static int maxContiguousSum(int[] nums) {
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }

        return  maxSum;
    }
}
