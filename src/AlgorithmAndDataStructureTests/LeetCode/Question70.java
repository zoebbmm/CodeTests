package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/15/16.
 */
public class Question70 {
    public static void main(String[] agrs) {
        System.out.println(findKthLargest(new int[]{1, 4, 2, 3, 5, 6}, 2));
    }
    /**
     * Since it only uses the partition algorithm, the average time complexity is O(n). However, the worst case complexity is O(n^2).
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int findKthLargestHelper(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return nums[lo];
        }

        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return nums[k];
        }

        if (pivot > k) {
            return findKthLargestHelper(nums, lo, pivot - 1, k);
        } else {
            return findKthLargestHelper(nums, pivot + 1, hi, k);
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;

        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
            }
        }

        swap(nums, lo, j);

        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
