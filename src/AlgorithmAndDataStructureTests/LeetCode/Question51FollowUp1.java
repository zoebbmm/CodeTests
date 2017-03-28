package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question51FollowUp1 {
    public static void main(String[] agrs) {
//        int[] nums = {10, 1, 2, 7, 6, 1, 5};

        int[] nums = {1, 2, 1, 5};


        List<List<Integer>> lists = combinationSumUniqueTimes(nums, 8);

        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ",");
            }

            System.out.println("********");
        }
    }

    public static List<List<Integer>> combinationSumUniqueTimes(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return lists;
        }

        List<Integer> currentList = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, 0, target, currentList, lists);

        return lists;
    }

    private static void dfs(int[] nums, int start, int target, List<Integer> currentList, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(currentList));
            return;
        }

//        if (target < 0) {
//            return;
//        }

        int prev = -1;

        for (int i = start; i < nums.length; i++) {
            if (target < nums[i]) return;

            if (prev != nums[i]) {
                currentList.add(nums[i]);
                dfs(nums, i + 1, target - nums[i], currentList, lists);
                currentList.remove(currentList.size() - 1);
                prev = nums[i];
            }
        }
    }
}
