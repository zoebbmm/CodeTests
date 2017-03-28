package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/15/16.
 */
public class Question136 {
    public int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;

        while (maxReach < n) {
            if (i < nums.length && nums[i] <= maxReach + 1) {
                maxReach += nums[i];
                i++;
            } else {
                patch++;
                maxReach += maxReach + 1;
            }
        }

        return patch;
    }
}
