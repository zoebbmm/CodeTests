package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question49FollowUp2 {
    public static void main(String[] agrs) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3}));

    }

    public static int removeDuplicates(int[] A) {
        // if the array is empty or has only one element
        if (A.length < 2) return A.length;

        int i = 0;
        int j = 1;
        while (j < A.length) {
            if (A[i] == A[j]) j++;
            else {
                i++;
                A[i] = A[j];
                j++;
            }
        }

        System.out.println(A.length);
        return i + 1;
    }
}
