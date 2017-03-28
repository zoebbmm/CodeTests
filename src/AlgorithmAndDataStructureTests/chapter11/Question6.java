package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question6 {
    //Time - O(M * log^N)
    public boolean findElementInMatrix(int[][] matrix, int tartgetElement) {
        int row = 0;

        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == tartgetElement) {
                return true;
            } else if (matrix[row][column] < tartgetElement) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }
}
