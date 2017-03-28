package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/1/16.
 */
public class Question232FollowUp2 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0] = new int[]{1, 5, 9};
        matrix[1] = new int[]{10, 11, 13};
        matrix[2] = new int[]{12, 13, 15};

        System.out.println(kthSmallest(matrix, 8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;

        int lower = matrix[0][0];
        int upper = matrix[m-1][m-1];

        while(lower<upper){
            int mid = lower + ((upper-lower)>>1);
            int count = count(matrix, mid);
            if(count<k){
                lower=mid+1;
            }else{
                upper=mid;
            }
        }

        return upper;
    }

    private static int count(int[][] matrix, int target){
        int m=matrix.length;
        int i=m-1;
        int j=0;
        int count = 0;

        while(i>=0&&j<m){
            if(matrix[i][j]<=target){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }

        return count;
    }
}
