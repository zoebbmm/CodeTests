package AlgorithmAndDataStructureTests.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question26 {
    public void convertBTToSinglyLinkedList(TreeNodeNext root) {
        if (root == null) return;

        Queue<TreeNodeNext> queue = new LinkedList<>();

        queue.add(root);

        TreeNodeNext prevNode = null;
        TreeNodeNext temp = null;

        while(!queue.isEmpty()) {
            prevNode = temp;

            temp = queue.poll();

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

            if (prevNode != null) {
                prevNode.next = temp;
            }
        }

        temp.next = null;

    }
}
