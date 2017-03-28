package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 11/27/16.
 */
public class Question123followUp6 {
    class Distance {
        int minDis = Integer.MAX_VALUE;
    }

    // Returns minimum distance of a leaf from given node x
    public int minimumDistance(TreeNode root, TreeNode x) {
        // Initialize result (minimum distance from a leaf)
        Distance d = new Distance();

        // Find closest leaf down to x
        findLeafDown(x, 0, d);

        // See if there is a closer leaf through parent
        findThroughParent(root, x, d);

        return d.minDis;
    }

    // This function finds closest leaf to root.  This distance
    // is stored at *minDist.
    private void findLeafDown(TreeNode root, int lev, Distance minDist) {

        // base case
        if (root == null)
            return;

        // If this is a leaf node, then check if it is closer
        // than the closest so far
        if (root.left == null && root.right == null) {
            if (lev < (minDist.minDis))
                minDist.minDis = lev;

            return;
        }

        // Recur for left and right subtrees
        findLeafDown(root.left, lev + 1, minDist);
        findLeafDown(root.right, lev + 1, minDist);
    }

    // This function finds if there is closer leaf to x through
    // parent node.
    private int findThroughParent(TreeNode root, TreeNode x, Distance minDist) {
        // Base cases
        if (root == null)
            return -1;

        if (root.data == x.data)
            return 0;

        // Search x in left subtree of root
        int l = findThroughParent(root.left, x, minDist);

        // If left subtree has x
        if (l != -1) {
            // Find closest leaf in right subtree
            findLeafDown(root.right, l + 2, minDist);
            return l + 1;
        }

        // Search x in right subtree of root
        int r = findThroughParent(root.right, x, minDist);

        // If right subtree has x
        if (r != -1) {
            // Find closest leaf in left subtree
            findLeafDown(root.left, r + 2, minDist);
            return r + 1;
        }

        return -1;
    }


}
