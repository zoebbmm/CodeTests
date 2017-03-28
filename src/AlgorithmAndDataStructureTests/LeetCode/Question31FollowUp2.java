package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31FollowUp2 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(5);
    }
    public static List<List<Integer>> rootToLeafSums(TreeNode root, int sum) {
        if (root == null) return null;

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        impl(root, sum, currentList, lists);

        return lists;
    }

    /**
     * Time - O(n)
     * @param root
     * @param sum
     * @param currentList
     * @param lists
     */
    private static void impl(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> lists) {
        if (root == null) return;

        int remainSum = sum - root.data;
        currentList.add(root.data);

        if (remainSum == 0 && root.left == null && root.right == null) {
            lists.add(currentList);
            return;
        }

        impl(root.left, remainSum, new ArrayList<>(currentList), lists);
        impl(root.right, remainSum, new ArrayList<>(currentList), lists);
        return;
    }
}
