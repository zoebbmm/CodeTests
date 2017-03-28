package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31 {
    public int SumNumbers(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int parentSum) {
        if (root == null) return 0;

        int currentSum = root.data + parentSum * 10;

        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return dfs(root.left, currentSum) + dfs(root.right, currentSum);
    }
}
