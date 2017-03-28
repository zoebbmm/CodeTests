package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question229 {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        countUnivalSubtreesHelper(root);

        return count;
    }

    private int countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Divide
        int left = countUnivalSubtreesHelper(root.left);
        int right = countUnivalSubtreesHelper(root.right);

        // left and right are all empty
        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            count++;
            return root.data;
        } else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
            if (root.data == left || root.data == right) {
                count++;
                return root.data;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (root.data == left && root.data == right) {
                count++;
                return root.data;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
