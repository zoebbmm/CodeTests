package AlgorithmAndDataStructureTests.LeetCode;

import java.util.TreeSet;

/**
 * Created by weizhou on 8/21/16.
 */
public class Question197FollowUp2 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{12, 1, 5, 10};

        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 4));

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer floor = treeSet.floor(nums[i] + t);
            Integer ceil = treeSet.ceiling(nums[i] - t);

            if ((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            treeSet.add(nums[i]);

            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }

        return false;
    }
}
