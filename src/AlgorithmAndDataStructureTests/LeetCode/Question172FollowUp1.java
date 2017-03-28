package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/14/16.
 */
public class Question172FollowUp1 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }

            if (nums[lo] < nums[hi]) {
                return nums[lo];
            } else if (nums[lo] < nums[mid]) {
                lo = mid;
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            }
        }

        return Math.min(nums[lo], nums[hi]);
    }
}
