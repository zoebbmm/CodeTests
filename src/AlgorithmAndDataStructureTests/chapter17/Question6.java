package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question6 {
    public void findIndeces(int[] arr) {
        int leftEndIndex = findLeftEndIndex(arr);

        int rightStartIndex = findRightStartIndex(arr);

        int minIndex = leftEndIndex + 1;

        if (minIndex == arr.length) return;

        int maxIndex = rightStartIndex - 1;

        if (maxIndex < 0) return;

        for (int i = leftEndIndex; i <= rightStartIndex; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }

            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }

        int leftIndex = findLeftIndex(arr, leftEndIndex, minIndex);

        int rightIndex = findRightIndex(arr, rightStartIndex, maxIndex);

        System.out.println(leftIndex + " & " + rightIndex);
    }

    private int findLeftEndIndex(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] < arr[i-1]) return i-1;
        }

        return arr.length - 1;
    }

    private int findRightStartIndex(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) return i + 1;
        }

        return 0;
    }

    private int findLeftIndex(int[] arr, int leftEndIndex, int minIndex) {
        for (int i = leftEndIndex - 1; i >= 0; i--) {
            if (arr[i] <= arr[minIndex]) {
                return i + 1;
            }
        }

        return 0;
    }

    private int findRightIndex(int[] arr, int rightStartIndex, int maxIndex) {
        for (int i = rightStartIndex; i < arr.length; i++) {
            if (arr[i] >= arr[maxIndex]) {
                return i - 1;
            }
        }

        return arr.length - 1;
    }
}
