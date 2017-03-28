package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question27FollowUp1 {
    class Data {
        int path = 0;
        int sum = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        Data data = max(root);

        return data.sum;
    }

    public Data max(TreeNode root) {
        Data data = new Data();

        if ( root == null) return data;

        Data leftSubtree = max(root.left);
        Data rightSubtree = max(root.right);

        data.path = Math.max(0, Math.max(leftSubtree.path, rightSubtree.path) + root.data);
        data.sum = Math.max(Math.max(leftSubtree.sum, rightSubtree.sum), leftSubtree.path + rightSubtree.path + root.data);

        return data;
    }
}
