package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question46 {
    public Boolean isSysmmetric(TreeNode root) {
        if (root == null) return true;

        return impl(root.left, root.right);
    }

    private Boolean impl(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.data == right.data) {
            return impl(left.left, right.right) && impl(left.right, right.left);
        } else {
            return false;
        }
    }
}
