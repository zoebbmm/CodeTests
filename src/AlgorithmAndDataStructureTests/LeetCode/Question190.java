package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question190 {
    public static void main(String[] agrs) {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int[] result = maxNumber(nums1, nums2, 5);


//        int[] nums1 = new int[]{3, 9};
//        int[] nums2 = new int[]{8, 9};
//        int[] result = maxNumber(nums1, nums2, 3);

//        int[] nums1 = new int[]{6, 7};
//        int[] nums2 = new int[]{6, 0, 4};
//        int[] result = maxNumber(nums1, nums2, 5);

//        int[] nums1 = new int[]{6, 0, 4};
//        int[] nums2 = new int[]{6, 7};
//        int[] result = maxNumber(nums1, nums2, 5);

        for (int i : result) {
            System.out.println(i);
        }

    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int n1 = nums1.length;
        int n2 = nums2.length;

        // step 1: find the largest number from each array, and merge into one
        for (int i = Math.max(0, k - n2); i <= Math.min(n1, k); i++) {
            int[] list1 = findMax(nums1, i);
            int[] list2 = findMax(nums2, k - i);

            // then merge into one
            int[] curr = merge(list1, list2);

            if (greater(curr, 0, result, 0)) {
                result = curr;
            }
        }

        return result;
    }

    private static int[] findMax(int[] nums, int k) {
        int[] result = new int[k];

        int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            while (len > 0 && (n - i > k - len) && nums[i] > result[len - 1]) {
                len--;
            }

            if (len < k) {
                result[len] = nums[i];
                len++;
            }
        }

        return result;
    }

    private static int[] merge(int[] list1, int[] list2) {
        int n1 = list1.length;
        int n2 = list2.length;

        int[] result = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < n1 + n2) {
            if (greater(list1, i, list2, j)) {
                result[k++] = list1[i++];
            } else {
                result[k++] = list2[j++];
            }
        }

        return result;
    }

    private static boolean greater(int[] list1, int pos1, int[] list2, int pos2) {
        int n1 = list1.length;
        int n2 = list2.length;

        while (pos1 < n1 && pos2 < n2 && list1[pos1] == list2[pos2]) {
            pos1++;
            pos2++;
        }

        if (pos2 == n2) {
            return true;
        }

        if (pos1 < n1 && list1[pos1] > list2[pos2]) {
            return true;
        }

        return false;
    }
}
