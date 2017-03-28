package AlgorithmAndDataStructureTests.LeetCode;

import java.util.TreeSet;

/**
 * Created by weizhou on 9/1/16.
 */
public class Question94FollowUp1 {
    public static void main(String[] agrs) {
        int[][] matrix = new int[4][3];
        matrix[0] = new int[]{-1, 0, 1};
        matrix[1] = new int[]{0, -2, 3};
        matrix[2] = new int[]{2, 4, -1};
        matrix[3] = new int[]{1, -2, 0};

        System.out.println(maxSumSubmatrix(matrix, 6));
    }
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;

        int row=matrix.length;
        int col=matrix[0].length;

        int m = Math.max(row, col);
        int n = Math.min(row, col);
        boolean isRowLarger = false;
        if(row>col)
            isRowLarger=true;

        int result = Integer.MIN_VALUE;

        for(int c1=0; c1<n; c1++){

            int[] each = new int[m];
            for(int c2=c1; c2>=0; c2--){

                for(int r=0; r<m; r++){
                    each[r]+=isRowLarger?matrix[r][c2]:matrix[c2][r];
                }

                result = Math.max(result, getLargestSumCloseToK(each, k));
            }
        }

        return result;
    }

    public static int getLargestSumCloseToK(int[] arr, int k){
        int sum=0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        int result=Integer.MIN_VALUE;
        set.add(0);

        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];

            Integer ceiling = set.ceiling(sum-k);
            if(ceiling!=null){
                result = Math.max(result, sum-ceiling);
            }

            set.add(sum);
        }

        return result;
    }
}
