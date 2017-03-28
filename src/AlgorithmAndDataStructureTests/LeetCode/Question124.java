package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question124 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(23);

        System.out.println(inorderSuccessor(root, root.left.right.left).data);
        System.out.println(inorderSuccessor(root, root.right.right) == null);

        System.out.println(inorderSuccessor(root, root.right).data);


    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (p.right != null) {
            return findMin(p.right);
        }

        // Case 2: p.right == null
        TreeNode succ = null;
        TreeNode q = root;

        while (q != null) {
            if (q.data > p.data) {
                succ = q;
                q = q.left;
            } else if (q.data < p.data) {
                q = q.right;
            } else {
                break;
            }
        }

        return succ;
    }

    private static TreeNode findMin(TreeNode root) {
        TreeNode p = root;

        while (p.left != null) {
            p = p.left;
        }

        return p;
    }
}
