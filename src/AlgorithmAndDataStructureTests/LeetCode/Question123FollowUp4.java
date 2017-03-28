package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question123FollowUp4 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight) {
            return (2 << (leftHeight - 1)) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int findLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 1;

        while (root.left != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    private int findRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 1;

        while (root.right != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}
