package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31FollowUp4 {
    int max = Integer.MIN_VALUE;

    TreeNode targetLeaf = null;

    public int maxSumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        maxSum(root, 0);

        print(root, targetLeaf);

        return max;
    }

    private void maxSum(TreeNode root, int prevSum) {
        if (root == null) return;

        int currentSume = root.data + prevSum;

        if (root.left == null && root.right == null) {
            if (currentSume > max) {
                max = currentSume;
                targetLeaf = root;
                return;
            }
        }

        maxSum(root.left, currentSume);
        maxSum(root.right, currentSume);
        return;
    }

    private Boolean print(TreeNode root, TreeNode targetLeaf) {
        if (root == null) return false;

        if (root == targetLeaf || (print(root.left, targetLeaf)) || (print(root.right, targetLeaf))) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }
}
