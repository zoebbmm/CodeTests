package AlgorithmAndDataStructureTests.TestBinarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weizhou on 6/25/16.
 */
public class BreadthFirstSortQueue {
    public void BFS(TreeNode root) {
        Queue q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode current = (TreeNode) q.poll();

            if (current.left != null) {
                q.add(current.left);
            }

            if (current.right != null) {
                q.add(current.right);
            }
        }
    }
}
