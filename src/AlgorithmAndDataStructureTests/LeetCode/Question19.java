package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question19 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            Stack<Integer> levelStack = new Stack<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (level % 2 == 1) {
                    levelList.add(curr.data);
                } else {
                    levelStack.push(curr.data);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            // for even level, dump the elments from the stack to the arraylist
            if (level % 2 == 0) {
                while (!levelStack.isEmpty()) {
                    levelList.add(levelStack.pop());
                }
            }
            result.add(levelList);
        }

        return result;
    }
}
