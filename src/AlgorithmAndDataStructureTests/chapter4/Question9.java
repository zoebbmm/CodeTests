package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/6/16.
 */
public class Question9 {
    // Time- O(nlog^n)
    // Space - O(log^n)
    public void findSum(Node root, int sum) {
        int[] path = new int[height(root)];

        findSumPaths(root, sum, path, 0);
    }

    private void findSumPaths(Node root, int sum, int[] path, int level) {
        if (root == null) return;

        path[level] = root.value;

        int tempSum = 0;

        for (int i = level; i>= 0; i--) {
            tempSum += tempSum + path[i];

            if (tempSum == sum) {
                print(path, i, level);
            }
        }

        findSumPaths(root.left, sum, path, level + 1);
        findSumPaths(root.right, sum, path, level + 1);
    }

    private int height(Node root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private void print(int[] path, int start, int end) {
        if (start > end) return;

        for (int i = start; i <= end; i++) {
            System.out.println(path[i] + " ");
        }
    }
}
