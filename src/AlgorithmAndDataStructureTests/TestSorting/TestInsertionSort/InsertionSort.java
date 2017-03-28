package AlgorithmAndDataStructureTests.TestSorting.TestInsertionSort;

/**
 * Created by weizhou on 6/20/16.
 */
public class InsertionSort {
    public static void main(String[] agrs) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        insertionSort(list);

        for(int i : list) {
            System.out.println(i);
        }
    }

    // O(n^2)
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int current = list[i];

            int k = 0;

            for(k = i-1; k >= 0 && (list[k] > current); k--) {
                list[k+1] = list[k];
            }

            list[k+1] = current;
        }
    }

    public static void insertionSortWei(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int current = list[i];

            int k = 0;

            for(k = i-1; k >= 0; k--) {
                if (list[k] > current) {
                    list[k + 1] = list[k];
                }
            }

            list[k+1] = current;
        }
    }
}
