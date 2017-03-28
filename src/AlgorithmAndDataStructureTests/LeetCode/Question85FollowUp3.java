package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question85FollowUp3 {
    public static void main(String[] agrs) {
        System.out.println(missingNumber(new int[]{3, 1, 2, 0}));

    }

    public static int missingNumber(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // when the ith element is not i
            while (A[i] != i) {
                // no need to swap when ith element is out of range [0,n]
                if (A[i] < 0 || A[i] >= n)
                    break;

                //handle duplicate elements
                if(A[i]==A[A[i]])
                    break;
                // swap elements
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }

        // Step 2: iterate again to find out the missing number
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) {
                return i;
            }
        }

        return A.length;
    }
}
