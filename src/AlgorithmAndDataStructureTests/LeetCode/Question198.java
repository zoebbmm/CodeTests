package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/21/16.
 */
public class Question198 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 1;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countNumbers(nums, mid);

            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi; // Or lo
    }

    private int countNumbers(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
            }
        }

        return count;
    }
}
