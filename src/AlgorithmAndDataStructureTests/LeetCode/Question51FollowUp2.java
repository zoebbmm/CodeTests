package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question51FollowUp2 {
    public List<List<Integer>> combinationSumKN(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>();

        dfs(k, n, 1, currentList, lists);

        return lists;
    }

    private void dfs(int k, int target, int start, List<Integer> currentList, List<List<Integer>> lists) {
        if (target == 0 && currentList.size() == k) {
            lists.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentList.add(i);
            dfs(k, target - i, i+1, currentList, lists);
            currentList.remove(currentList.size() - 1);
        }
    }
}
