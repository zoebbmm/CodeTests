package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question87 {
    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        int red = 0;
        int blue = A.length - 1;

        int i = 0;
        while (i <= blue) {
            if (A[i] == 0) {
                swap(A, i, red);
                red++;
                i++;
            } else if (A[i] == 2) {
                swap(A, i, blue);
                blue--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
