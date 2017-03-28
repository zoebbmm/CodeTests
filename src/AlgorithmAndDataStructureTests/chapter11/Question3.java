package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/9/16.
 */
public class Question3 {
    //Time- O(n)
    public int findInRotatedArray(int[] arr, int x) {
        int targetIndex = impl(arr, 0, arr.length - 1, x);

        return arr[targetIndex];
    }

    private int impl(int[] arr, int leftIndex, int rightIndex, int x) {
        if (rightIndex < leftIndex) return -1;

        int midIndex = (leftIndex + rightIndex)/2;

        if (arr[midIndex] == x) return midIndex;

        if (arr[midIndex] > arr[leftIndex]) {
            if (x >= arr[leftIndex] && x < arr[midIndex]) {
                return impl(arr, leftIndex, midIndex - 1, x);
            } else {
                return impl(arr, midIndex + 1, rightIndex, x);
            }
        } else if (arr[midIndex] < arr[leftIndex]) {
            if (x > arr[midIndex] && x <= arr[rightIndex]) {
                return impl(arr, midIndex + 1, rightIndex, x);
            } else {
                return impl(arr, leftIndex, midIndex - 1, x);
            }
        } else {
            if (arr[midIndex] != arr[rightIndex]) {
                return impl(arr, midIndex+1, rightIndex, x);
            } else {
                int result = impl(arr, leftIndex, midIndex - 1, x);

                if (result == -1) {
                    return impl(arr, midIndex + 1, rightIndex, x);
                } else {
                    return result;
                }
            }
        }
    }
}
