package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question21 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        System.out.println(maxWidth(root));

    }

    private static int maxWidth = Integer.MIN_VALUE;

    public static int maxWidth(TreeNode root) {
        if (root == null) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        countNodes(root, map, 0);

        return maxWidth;
    }

    private static void countNodes(TreeNode root, HashMap<Integer, Integer> map, int level) {
        if (root == null) return;

        if (map.containsKey(level)) {
            map.put(level, map.get(level) + 1);
        } else {
            map.put(level, 1);
        }

        maxWidth = Math.max(maxWidth, map.get(level));

        countNodes(root.left, map, level + 1);
        countNodes(root.right, map, level + 1);
    }
}
