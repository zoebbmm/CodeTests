package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by weizhou on 8/14/16.
 */
public class Question74FollowUp5 {
    public static void main(String[] agrs) {
        int[][] grid = new int[3][5];

        grid[0] = new int[]{1, 0, 0, 0, 1};
        grid[1] = new int[]{0, 0, 0, 0, 0};
        grid[2] = new int[]{0, 0, 1, 0, 0};

        System.out.println(minTotalDistance(grid));

    }
    public static int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }

        int sum = 0;
        int mid = rowIndex.get(rowIndex.size() / 2);
        for (int x : rowIndex) {
            sum += Math.abs(x - mid);
        }

        Collections.sort(colIndex);
        mid = colIndex.get(colIndex.size() / 2);

        for (int y : colIndex) {
            sum += Math.abs(y - mid);
        }

        return sum;
    }
}
