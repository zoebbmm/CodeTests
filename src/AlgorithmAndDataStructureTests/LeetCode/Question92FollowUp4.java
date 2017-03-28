package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 11/12/16.
 */
public class Question92FollowUp4 {

    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
}
