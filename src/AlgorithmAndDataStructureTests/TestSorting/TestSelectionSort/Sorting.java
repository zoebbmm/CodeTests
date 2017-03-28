package AlgorithmAndDataStructureTests.TestSorting.TestSelectionSort;

import java.util.List;

/**
 * Created by weizhou on 5/25/16.
 */
public class Sorting {
    public void sort(List<Integer> list) {

        int i = 0;
        int j = i+1;

        while ((i < j) && (j < list.size())) {
            if (list.get(i) > list.get(j)) {
                int temp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, temp);

                i = 0;
                j = i+1;
            } else {
                i++;
                j++;
            }
        }

        list.forEach(integer -> System.out.println(integer));
    }
}
