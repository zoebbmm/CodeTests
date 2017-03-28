package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question12 {
    // Time - BestCase: O(nlog^n)
    // Time - WorstCase: O(n^2)
    public TreeNode convertArraysToBST(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootValue = preOrder[preStart];
        int rootIndex = 0;

        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);

        int leftSubTreeLength = rootIndex - inStart;

        root.left = convertArraysToBST(preOrder, preStart + 1, preStart + leftSubTreeLength, inorder, inStart, rootIndex - 1);
        root.right = convertArraysToBST(preOrder, preStart + leftSubTreeLength + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
