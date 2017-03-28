package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question30FollowUp3 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]!=0){
                    int curPerimeter = 4;
                    curPerimeter -= i-1>=0?(grid[i-1][j]==1?1:0):0;
                    curPerimeter -= j-1>=0?(grid[i][j-1]==1?1:0):0;
                    curPerimeter -= i+1<n?(grid[i+1][j]==1?1:0):0;
                    curPerimeter -= j+1<m?(grid[i][j+1]==1?1:0):0;
                    res += curPerimeter;
                }
            }
        }
        return res;
    }
}
