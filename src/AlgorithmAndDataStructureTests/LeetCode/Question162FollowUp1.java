package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/24/16.
 */
public class Question162FollowUp1 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(14);
//        root.left.right.left = new TreeNode(2);
//        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(20);

        System.out.println(largestBSTSubtree(root));
    }
    static class Data {
        int size = 0;
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;
        boolean isBST = false;
    }

    private static int max = 0;

    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        largestBSTHelper(root);

        return max;
    }

    private static Data largestBSTHelper(TreeNode root) {
        Data curr = new Data();
        if (root == null) {
            curr.isBST = true;
            return curr;
        }

        Data left = largestBSTHelper(root.left);
        Data right = largestBSTHelper(root.right);

        curr.lower = Math.min(root.data, Math.min(left.lower, right.lower));
        curr.upper = Math.max(root.data, Math.max(left.upper, right.upper));

        if (left.isBST && root.data > left.upper && right.isBST && root.data < right.lower) {
            curr.size = left.size + right.size + 1;
            curr.isBST = true;
            max = Math.max(max, curr.size);
        } else {
            curr.size = 0;
        }

        return curr;
    }
}
