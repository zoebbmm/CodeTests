package GenericConceptTests.TestBreak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 9/21/16.
 */
public class Main {
    public static void main(String[] agrs) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr1 = new int[]{4, 5, 6, 7};

        List<int[]> list = new ArrayList<>();
        list.add(arr);
        list.add(arr1);

        for (int[] ar : list) {
            System.out.println("size: " + ar.length);
            for (int i : ar) {
                System.out.println("i: " + i);
                if (i == 2) {
                    System.out.println("break: " + i);
                    break;
                }
            }
        }
    }
}
