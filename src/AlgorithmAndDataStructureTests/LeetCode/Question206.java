package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question206 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                hi = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            }
        }

        if (nums[lo] > nums[hi]) {
            return lo;
        } else {
            return hi;
        }
    }
}
