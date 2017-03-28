package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question92FollowUp2 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return upsideDownBinaryTreeHelper(root, null);
    }

    private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
        if (root == null) {
            return parent;
        }

        TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);

        root.left = parent == null ? null : parent.right;
        root.right = parent;

        return newNode;
    }
}
