package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question18 {
    public void connect(TreeNodeNext root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.next != null && root.next.left != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
