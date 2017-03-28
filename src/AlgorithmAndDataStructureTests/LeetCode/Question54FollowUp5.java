package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54FollowUp5 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};

        System.out.println(threeSumSmaller(nums, 2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    result += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
