package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/29/16.
 */
public class Question113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);

        System.out.println(kthSmallest(root, 3));
    }

    private static int counter = 0;
    private static boolean found = false;
    private static int val = Integer.MIN_VALUE;
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        kthSmallestHelper(root, k);

        return val;
    }

    private static void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (!found) {
            kthSmallestHelper(root.left, k);
        }

        counter++;
        if (counter == k) {
            found = true;
            val = root.data;
            return;
        }

        if (!found) {
            kthSmallestHelper(root.right, k);
        }
    }

    /**
     * Follow Up:
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
     * How would you optimize the kthSmallest routine?
     */

    public int kthSmallestFollowUp(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int leftNodes = getNumberNodes(root.left);
        if(k == leftNodes + 1) {
            return root.data;
        } else if (k > leftNodes + 1) {
            return kthSmallestFollowUp(root.right, k - leftNodes - 1);
        } else {
            return kthSmallestFollowUp(root.left, k);
        }
    }

    private int getNumberNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getNumberNodes(root.left) + getNumberNodes(root.right) + 1;
    }
}
