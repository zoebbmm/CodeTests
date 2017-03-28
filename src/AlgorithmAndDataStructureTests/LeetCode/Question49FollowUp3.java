package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question49FollowUp3 {
    public static void main(String[] agrs) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));

    }

    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 1;
        int count = 1;

        while (j < A.length) {
            if (A[j] == A[j - 1] && count == 1) {
                A[++i] = A[j++];
                count++;
            } else if (A[j] == A[j - 1] && count > 1) {
                j++;
            } else {
                count = 1;
                A[++i] = A[j++];
            }
        }

        return i + 1;
    }
}
