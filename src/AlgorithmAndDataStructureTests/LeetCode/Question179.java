package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question179 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println(longestConsecutive(root));
    }
    private static int max = 0;
    public static int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.data);
        return max;
    }

    public static void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.data == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.data + 1);
        helper(root.right, cur, root.data + 1);
    }
}
