package AlgorithmAndDataStructureTests.TestSorting.TestQuickSort;

/**
 * Created by weizhou on 6/17/16.
 */
public class QuickSorting {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, 0, 3, 14, 12};
        quickSort(list);

        for(int i : list) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] list) {
        int first = 0;
        int last = list.length-1;

        quickSortImplementation(list, first, last);
    }

    private static void quickSortImplementation(int[] list, int first, int last) {
        if(last > first) {
            int pivotIndex = partition(list, first, last);

            quickSortImplementation(list, first, pivotIndex - 1);
            quickSortImplementation(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];

        int lowIndex = first + 1;
        int highIndex = last;

        while(highIndex > lowIndex) {
            while (lowIndex <= highIndex && (list[lowIndex] <= pivot)) {
                lowIndex++;
            }

            while (lowIndex <= highIndex && (list[highIndex] > pivot)) {
                highIndex--;
            }

            if (highIndex > lowIndex) {
                int temp = list[highIndex];
                list[highIndex] = list[lowIndex];
                list[last] = temp;
            }
        }

        while (highIndex > first && (list[highIndex] >= pivot)) {
            highIndex--;
        }

        if (pivot > list[highIndex]) {
            list[first] = list[highIndex];
            list[highIndex] = pivot;
            return highIndex;
        } else {
            return first;
        }
    }
}
