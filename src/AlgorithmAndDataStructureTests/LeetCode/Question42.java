package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/8/16.
 */
public class Question42 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> lists = findPermutation(nums);

        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    // Distinct elements
    // Time - O(n!)
    // Space - O(n)
    public static List<List<Integer>> findPermutation(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>();

        impl(nums, lists, currentList);

        return lists;
    }

    private static void impl(int[] nums, List<List<Integer>> lists, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            lists.add(new ArrayList<>(currentList));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentList.contains(nums[i])) continue;

            currentList.add(nums[i]);
            impl(nums, lists, currentList);
            currentList.remove(currentList.size() - 1);
        }

        return;
    }
}
