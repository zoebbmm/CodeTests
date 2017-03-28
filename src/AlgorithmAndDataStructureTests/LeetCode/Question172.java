package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/14/16.
 */
public class Question172 {
    public static void main(String[] agrs) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi)/2;

            if (nums[lo] < nums[hi]) {
                return nums[lo];
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[lo] < nums[mid]) {
                lo = mid;
            }
        }

        return Math.min(nums[lo], nums[hi]);
    }
}
