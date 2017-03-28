package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/1/16.
 */
public class Question30FollowUp1 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    numIslandsHelper(grid, visited, i, j, rows, cols);
                }
            }
        }

        return result;
    }

    private void numIslandsHelper(char[][] grid, boolean[][] visited, int i, int j, int numRows, int numCols) {
        if (i < 0 || i >= numRows) {
            return;
        }

        if (j < 0 || j >= numCols) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        // If water
        if (grid[i][j] == '0') {
            return;
        }

        // Mark the visted[i][j] = true
        visited[i][j] = true;

        // Go up, down, left and right
        numIslandsHelper(grid, visited, i - 1, j, numRows, numCols);
        numIslandsHelper(grid, visited, i + 1, j, numRows, numCols);
        numIslandsHelper(grid, visited, i, j - 1, numRows, numCols);
        numIslandsHelper(grid, visited, i, j + 1, numRows, numCols);
    }
}
