package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question257FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{2, 1, 3, 4};

        System.out.println(minMoves2(nums));
        System.out.println(minMoves2QuickSelect(nums));

    }
    /**
     * Time - O (nlogN)
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }

    /**
     * Time - O(n)
     *
     * @param nums
     * @return
     */
    public static int minMoves2QuickSelect(int[] nums) {
        int sum = 0;
        int median = findMedian(nums, 0, nums.length - 1, (nums.length/2) +1);
        for (int i=0;i<nums.length;i++) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }

    private static int findMedian(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return lo;
        }

        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return pivot;
        }

        if (pivot > k) {
            return findMedian(nums, lo, pivot - 1, k);
        } else {
            return findMedian(nums, pivot + 1, hi, k);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];

        int lowIndex = first + 1;
        int highIndex = last;

        while(highIndex > lowIndex) {
            while (lowIndex <= highIndex && (list[lowIndex] <= pivot)) {
                lowIndex++;
            }

            while (lowIndex <= highIndex && (list[highIndex] > pivot)) {
                highIndex--;
            }

            if (highIndex > lowIndex) {
                int temp = list[highIndex];
                list[highIndex] = list[lowIndex];
                list[last] = temp;
            }
        }

        while (highIndex > first && (list[highIndex] >= pivot)) {
            highIndex--;
        }

        if (pivot > list[highIndex]) {
            list[first] = list[highIndex];
            list[highIndex] = pivot;
            return highIndex;
        } else {
            return first;
        }
    }

}
