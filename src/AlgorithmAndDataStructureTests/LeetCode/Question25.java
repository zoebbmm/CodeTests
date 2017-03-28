package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question25 {
    public int[] merge2Arrays(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];

        int aIndex = 0;

        int bIndex = 0;

        int mergeIndex = 0;

        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] < B[bIndex]) {
                merged[mergeIndex++] = A[aIndex++];
            } else {
                merged[mergeIndex++] = B[bIndex++];
            }
        }

        while (aIndex < A.length) {
            merged[mergeIndex++] = A[aIndex++];
        }

        while (bIndex < B.length) {
            merged[mergeIndex++] = B[bIndex++];
        }

        return merged;
    }
}
