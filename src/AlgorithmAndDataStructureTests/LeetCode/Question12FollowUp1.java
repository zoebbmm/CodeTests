package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question12FollowUp1 {
    public static void main(String[] args) {
        int[] inOrder = {4, 10, 3, 1, 7, 11, 8, 2, 9};
        int[] postOrder = {4, 1, 3, 10, 11, 8, 9, 2, 7};

        TreeNode root = convertInorderPostOrderToBST(inOrder, 0, 8, postOrder, 0, 8);

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.left.right.right.data);
        System.out.println(root.right.left.data);
        System.out.println(root.right.right.data);
        System.out.println(root.right.left.left.data);
    }

    public static TreeNode convertInorderPostOrderToBST(int[] inOrder, int inStart, int inEnd, int[] postOrder, int poStart, int poEnd) {
        if (inStart > inEnd) return null;

        int rootValue = postOrder[poEnd];
        int rootIndex = 0;

        for (int i = inStart; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        int leftSubtreeLength = rootIndex - inStart;

        TreeNode root = new TreeNode(rootValue);

        root.left = convertInorderPostOrderToBST(inOrder, inStart, rootIndex - 1, postOrder, poStart, poStart + leftSubtreeLength - 1);
        root.right = convertInorderPostOrderToBST(inOrder, rootIndex + 1, inEnd, postOrder, poEnd - leftSubtreeLength, poEnd - 1);

        return root;
    }
}
