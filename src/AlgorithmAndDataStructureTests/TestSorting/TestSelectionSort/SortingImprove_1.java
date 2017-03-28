package AlgorithmAndDataStructureTests.TestSorting.TestSelectionSort;

import java.util.List;

/**
 * Created by weizhou on 5/25/16.
 */
public class SortingImprove_1 {
    //O(n^2)
    public void sort(List<Integer> list) {
        int i = 0;
        int j = 0;
        int size = list.size();

        for (i = 0; i < size -1; i++) {
            int min = list.get(i);
            int minIndex = i;

            //find the smallest
            for (j = i + 1; j < size; j++) {
                if (min > list.get(j)) {
                    min = list.get(j);
                    minIndex = j;
                }
            }

            //swap
            if (minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }

        list.forEach(integer -> System.out.println(integer));
    }
}
