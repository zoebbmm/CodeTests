package AlgorithmAndDataStructureTests.TestSorting.TestBubbleSort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 6/16/16.
 */
public class BubbleSorting {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 2, 5, 6, 1, -2, 3, 14, 12);
        bubbleSort(list);
        list.forEach(integer -> System.out.println(integer));
    }

    // Best case O(n)
    // Worst case O(n^2)
    public static void bubbleSort(List<Integer> list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.size() && needNextPass; k++) {

            needNextPass = false;
            for (int i = 0; i < (list.size()-k); i++) {
                if (list.get(i) > list.get(i+1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    needNextPass = true;
                }
            }
        }
    }
}
