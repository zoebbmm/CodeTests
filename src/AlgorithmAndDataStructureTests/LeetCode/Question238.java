package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;

/**
 * Created by weizhou on 9/1/16.
 */
public class Question238 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // if matrix is null or empty
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = 0;


        // Handle the circle
        while (m > 0 & n > 0) {
            // For matrix has only 1 row
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[row][col++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[row++][col]);
                }
                break;
            }

            // move right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[row][col++]);
            }

            // move down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[row++][col]);
            }

            // move left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[row][col--]);
            }

            // move up
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[row--][col]);
            }

            // move to the inner circle
            row++;
            col++;
            m -= 2;
            n -= 2;
        }

        return result;
    }
}
