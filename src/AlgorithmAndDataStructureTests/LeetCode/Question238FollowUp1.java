package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/1/16.
 */
public class Question238FollowUp1 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int start = 1;
        int row = 0;
        int col = 0;

        while (n > 0) {
            if (n == 1) {
                result[row][col] = start;
                break;
            }

            // Move right
            for (int i = 0; i < n - 1; i++) {
                result[row][col++] = start++;
            }

            // Move down
            for (int i = 0; i < n - 1; i++) {
                result[row++][col] = start++;
            }

            // Move left
            for (int i = 0; i < n - 1; i++) {
                result[row][col--] = start++;
            }

            // Move up
            for (int i = 0; i < n - 1; i++) {
                result[row--][col] = start++;
            }

            row++;
            col++;
            n -= 2;
        }

        return result;
    }
}
