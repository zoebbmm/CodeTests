package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question85 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{4, 1, 2, 0};

        System.out.println(firstMissingPositiveAnd0(nums));
    }
    public static int firstMissingPositiveAnd0(int A[]) {
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

        for (int i = 1; i < n; i++) {
            if (A[i] != i)
                return i;
        }

        if (A[0] == n) return n+1;

        return n;
    }
}
