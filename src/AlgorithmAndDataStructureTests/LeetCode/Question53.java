package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question53 {
    TreeNode prev = null;

    public void flattenBTToList(TreeNode root) {
        if (root == null) return;

        flattenBTToList(root.right);
        flattenBTToList(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
        return;
    }
}
