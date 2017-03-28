package AlgorithmAndDataStructureTests.TestBinarySearch;

import java.util.Stack;

/**
 * Created by weizhou on 6/25/16.
 */
public class DepthFirstSortStack {
    public void DFS(TreeNode root) {
        Stack stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = (TreeNode)stack.pop();

            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }
        }
    }
}
