package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question24 {
    public void findMax2Numbers(int[] nums) {
        int secondMax = 0;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;

                max = nums[i];
            }

            if (secondMax < nums[i] && max != nums[i]) {
                secondMax = nums[i];
            }
        }

        System.out.println(secondMax);
        System.out.println(max);
    }
}
