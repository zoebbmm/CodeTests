package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31FollowUp3 {
    public List<List<Integer>> findAllRootToLeafPaths(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        impl(root, currentList, lists);

        return lists;
    }

    private void impl(TreeNode root, List<Integer> currentList, List<List<Integer>> lists) {
        if (root == null) return;

        currentList.add(root.data);

        if (root.left == null && root.right == null) {
            lists.add(currentList);
            return;
        }

        impl(root.left, new ArrayList<>(currentList), lists);
        impl(root.right, new ArrayList<>(currentList), lists);
        currentList.remove(currentList.size() - 1);
        return;
    }
}
