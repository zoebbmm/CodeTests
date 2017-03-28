package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question151 {
    public int closestValue(TreeNode root, double target) {
        int a = root.data;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}
