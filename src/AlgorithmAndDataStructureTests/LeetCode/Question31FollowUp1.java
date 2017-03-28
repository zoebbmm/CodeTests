package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31FollowUp1 {
    /**
     * Time - O(nlog^n)
     * @param root
     * @param sum
     * @return
     */
    public Boolean isRootToLeafSumExists(TreeNode root, int sum) {
        if (root == null) return false;

        int remainSum = sum - root.data;

        if (remainSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        Boolean leftSubtree = isRootToLeafSumExists(root.left, remainSum);
        Boolean rightSubtree = isRootToLeafSumExists(root.right, remainSum);

        return leftSubtree || rightSubtree;
    }
}
