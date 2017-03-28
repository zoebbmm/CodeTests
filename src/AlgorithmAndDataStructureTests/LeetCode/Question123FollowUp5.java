package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/9/16.
 */
public class Question123FollowUp5 {


    // This function returns sum of all left leaves in a given
    // binary tree
    public int leftLeavesSum(TreeNode node) {
        // Initialize result
        int res = 0;

        // Update result if root is not NULL
        if (node != null) {
            // If left of root is NULL, then add key of
            // left child
            if (isLeaf(node.left))
                res += node.left.data;
            else // Else recur for left child of root
                res += leftLeavesSum(node.left);

            // Recur for right child of root and update res
            res += leftLeavesSum(node.right);
        }

        // return result
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}
