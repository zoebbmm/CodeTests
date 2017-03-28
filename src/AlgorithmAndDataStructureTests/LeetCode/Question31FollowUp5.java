package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question31FollowUp5 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);

        root.left.left.left = new TreeNode(5);

        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(findSum(root, 8));

    }
    static int count = 0;

    public static int findSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int depth = depth(root);

        int[] path = new int[depth];

        findSumHelper(root, path, sum, 0);

        return count;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) +1;
        }
    }

    private static void findSumHelper(TreeNode root, int[] path, int sum, int level) {
        if(root == null) {
            return;
        }

        path[level] = root.data;
        int t = 0;

        for (int i = level; i >= 0; i--) {
            t+= path[i];
            if (t == sum) {
                count++;
                printPath(path, i, level);
            }
        }

        findSumHelper(root.left, path, sum, level + 1);
        findSumHelper(root.right, path, sum, level + 1);
    }

    private static void printPath(int[]path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(path[i]);
        }

        System.out.println();
    }
}
