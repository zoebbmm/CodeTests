package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/3/16.
 */
public class Question241 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0;
        int j = 0;

        // Step 1: compress the nums array by filling out the 0s
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
                i++;
            } else {
                i++;
            }
        }

        // Append 0s to the end
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
