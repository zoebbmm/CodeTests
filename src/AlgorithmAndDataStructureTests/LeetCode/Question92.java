package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question92 {
    TreeNode p,q;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {

        inOrderTraversal(root);

        int temp = p.data;
        p.data = q.data;
        q.data = temp;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);

        if (prev != null && root.data < prev.data) {
            if (p == null) {
                p = prev;
                q = root;
            } else {
                q = root;
            }
        }
        prev = root;
        inOrderTraversal(root.right);
    }
}
