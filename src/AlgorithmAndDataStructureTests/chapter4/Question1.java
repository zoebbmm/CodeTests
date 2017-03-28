package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/3/16.
 */
public class Question1 {

    // Time Complexity (O(N)), Space Complexity(O(log^N))
    public Boolean isBalancedTree(Node root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int checkHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        int heightOffset = leftHeight - rightHeight;

        if (Math.abs(heightOffset) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
