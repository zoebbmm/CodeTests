package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/6/16.
 */
public class Question74FollowUp4 {
    int longest=0;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                helper(matrix, i, j, 1);
            }
        }

        return longest;
    }

    public void helper(int[][] matrix, int i, int j, int len){

        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]){
            longest = Math.max(longest, len+1);
            helper(matrix, i-1, j, len+1);
        }

        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j]){
            longest = Math.max(longest, len+1);
            helper(matrix, i+1, j, len+1);
        }

        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]){
            longest = Math.max(longest, len+1);
            helper(matrix, i, j-1, len+1);
        }

        if(j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]){
            longest = Math.max(longest, len+1);
            helper(matrix, i, j+1, len+1);
        }

    }
}
