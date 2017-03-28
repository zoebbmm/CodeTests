package AlgorithmAndDataStructureTests.LeetCode.Facebook;

import java.util.ArrayList;

/**
 * Created by weizhou on 12/17/16.
 */
public class SortArray {
    public Integer[] sqArray(int[] arr) {
        ArrayList<Integer> arr_negetive = new ArrayList<Integer>();
        ArrayList<Integer> arr_positive = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr_negetive.add(arr[i] * arr[i]);
            } else {
                arr_positive.add(arr[i] * arr[i]);
            }
        }
        Integer[] array_result = new Integer[arr.length];
        int n = arr_negetive.size() - 1;//negetive counter
        int p = 0;//positive counter
        int count = 0;
        while (count < arr.length) {
            System.out.println(p + "," + n);
            if (n < 0 && p < arr_positive.size()) {
                array_result[count] = (arr_positive.get(p));
                p++;
            } else if (p == arr_positive.size() && n >= 0) {
                array_result[count] = (arr_negetive.get(n));
                n--;
            } else if (arr_negetive.get(n) < arr_positive.get(p)) {
                array_result[count] = (arr_negetive.get(n));
                n--;
            } else {
                array_result[count] = (arr_positive.get(p));
                p++;
            }
            count++;

        }
        if (arr_negetive.size() == 0) {
            return arr_positive.toArray(new Integer[arr_positive.size()]);
        } else if (arr_positive.size() == 0) {
            return arr_negetive.toArray(new Integer[arr_negetive.size()]);
        } else {
            return array_result;
        }

    }
}
