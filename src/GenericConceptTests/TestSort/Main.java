package GenericConceptTests.TestSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weizhou on 9/21/16.
 */
public class Main {
    public static void main (String[] agrs) {
        System.out.println("303".compareTo("330"));

        Integer[] arr = new Integer[]{4, 2, 6};

        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("Compare " + o1 + " & " + o2);

                int res = o2.compareTo(o1);
                System.out.println("Compare Result: " + res);
                return res;
            }
        });

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
