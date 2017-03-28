package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question42FollowUp1 {
    public static void main(String[] args) {
        int[] numsDup = {1, 2, 2};

        List<List<Integer>> listsDup = findPermutations(numsDup);

        for (List<Integer> list : listsDup) {
            for (int i : list) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    // Duplicate elements
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>();

        Boolean[] used = new Boolean[nums.length];

        impl(nums, lists, currentList, used);

        return lists;
    }

    private static void impl(int[] nums, List<List<Integer>> lists, List<Integer> currentList, Boolean[] used) {
        if (currentList.size() == nums.length) {
            lists.add(new ArrayList<>(currentList));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && (nums[i] == nums[i-1]) && !used[i-1]) continue;

            currentList.add(nums[i]);
            used[i] = true;
            impl(nums, lists, currentList, used);
            currentList.remove(currentList.size() - 1);
            used[i] = false;
        }

        return;
    }
}
