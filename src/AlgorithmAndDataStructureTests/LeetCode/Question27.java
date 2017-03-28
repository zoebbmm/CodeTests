package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question27 {
    class Data {
        int height;
        int diameter;
    }

    public int longestPathorDiameterOfBT(TreeNode root) {
        if (root == null) return 0;

        Data data = new Data();

        impl(root, data);

        return data.diameter;
    }

    private void impl(TreeNode root, Data data) {
        if (root == null) {
            data.height = 0;
            data.diameter = 0;
            return;
        }

        impl(root.left, data);

        int leftHeight = data.height;
        int leftDiameter = data.diameter;

        impl(root.right, data);

        data.diameter = Math.max(Math.max(leftDiameter, data.diameter), leftHeight + data.height + 1);
        data.height = Math.max(leftHeight, data.height) + 1;
        return;
    }
}
