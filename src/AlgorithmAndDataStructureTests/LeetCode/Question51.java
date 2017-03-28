package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question51 {
    public static void main(String[] agrs) {
        int[] nums = {2, 3, 6, 7};


        List<List<Integer>> lists = combinationSumRepeatedlyUsed(nums, 8);

        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ",");
            }

            System.out.println("********");
        }
    }


    /**
     * Time- O(n!)
     * Space - O(n)
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSumRepeatedlyUsed(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return lists;
        }

        List<Integer> currentList = new ArrayList<>();

        dfs(nums, 0, target, currentList, lists);

        return lists;
    }

    private static void dfs(int[] nums, int start, int target, List<Integer> currentList, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if (target < nums[i]) return;

            currentList.add(nums[i]);
            dfs(nums, i, target - nums[i], currentList, lists);
            currentList.remove(currentList.size() - 1);
        }
    }
}
