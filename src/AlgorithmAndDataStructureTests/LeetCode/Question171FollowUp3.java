package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/30/16.
 */
public class Question171FollowUp3 {
    public static void main(String[] agrs) {
        int[][] matrix = new int[3][3];

        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        int[] result = modify(matrix);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] modify(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return null;
        }

        int[] result = new int[m.length * m[0].length];
        int idx = 0;
        for (int i = 0; i < m.length; i++) {
            if (i % 2 == 0) {
                for (int c = 0; c < m[0].length; c++) {
                    result[idx++] = m[i][c];
                }

            } else {
                for (int c = m[0].length - 1; c >= 0; c--) {
                    result[idx++] = m[i][c];
                }
            }
        }
        return result;
    }
}
