package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/21/16.
 */
public class Question203 {
    public static void main(String[] agrs) {
        int[] nums = {2, 1, 2, 3, 2, 2};

        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}
