package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question18FollowUp1 {
    public void connect(TreeNodeNext root) {
        TreeNodeNext dummyHead = new TreeNodeNext(0);
        TreeNodeNext pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}
