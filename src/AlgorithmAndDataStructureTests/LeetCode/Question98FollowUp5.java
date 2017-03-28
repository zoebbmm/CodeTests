package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/15/16.
 */
public class Question98FollowUp5 {

    public static void main(String[] agrs) {
        int[] nums = new int[]{1, 2, 3, 5, 7};

        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int size = nums.length;

        if (size < 3) {
            return 0;
        }

        int ans = 0;
        int count = 0;

        int delta = nums[1] - nums[0];

        for (int i = 2; i < size; i++) {
            if (nums[i] - nums[i - 1] == delta) {
                count+=1;
                ans+=count;
            } else {
                delta = nums[i] - nums[i - 1];
                count = 0;
            }
        }

        return ans;
    }
}
