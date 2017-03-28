package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/9/16.
 */
public class Question1 {
    public void mergeTwoSortedArrays(int[] A, int[] B) {

        int endA = A.length - 1;

        int endB = B.length - 1;

        int mergedArrayEndIndex = A.length + B.length - 1;

        while (endA >= 0 && endB >=0 ) {
            if (A[endA] > B[endB]) {
                A[mergedArrayEndIndex] = A[endA];
                mergedArrayEndIndex--;
                endA--;
            } else {
                A[mergedArrayEndIndex] = B[endB];
                mergedArrayEndIndex--;
                endB--;
            }
        }

        while (endB >= 0) {
            A[mergedArrayEndIndex] = B[endB];
            mergedArrayEndIndex--;
            endB--;
        }
    }
}
