package AlgorithmAndDataStructureTests.chapter18;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question6 {
    public int findithSmallestNumber(int[] arr, int rank) {
        int first = 0;

        int last = arr.length - 1;

        int ithSmallestIndex = impl(arr, first, last, rank);

        return ithSmallestIndex;
    }

    private int impl(int[] arr, int first, int last, int rank) {
        int pivotIndex = partition(arr, first, last);

        int leftSize = pivotIndex - first + 1;

        if (leftSize == rank) {
            return pivotIndex;
        } else if (leftSize > rank) {
            return impl(arr, first, pivotIndex, rank);
        } else{
            return impl(arr, pivotIndex + 1, last, rank - leftSize);
        }
    }

    private int partition(int[] arr, int first, int last) {
        int pivot = arr[first];

        int lowIndex = first +1;

        int highIndex = last;

        while (lowIndex < highIndex) {
            while (lowIndex <= highIndex && arr[lowIndex] <= pivot) {
                lowIndex++;
            }

            while (lowIndex <= highIndex && arr[highIndex] > pivot) {
                highIndex--;
            }

            if (lowIndex < highIndex) {
                int temp = arr[lowIndex];
                arr[lowIndex] = arr[highIndex];
                arr[highIndex] = temp;
            }
        }

        while (highIndex > first && arr[highIndex] >= pivot) {
            highIndex--;
        }

        if (arr[highIndex] < pivot) {
            arr[first] = arr[highIndex];
            arr[highIndex] = pivot;
            return highIndex;
        } else {
            return first;
        }
    }
}
