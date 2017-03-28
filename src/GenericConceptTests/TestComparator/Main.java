package GenericConceptTests.TestComparator;

import java.util.Arrays;

/**
 * Created by weizhou on 7/12/16.
 */
public class Main {
    public static void main(String[] agrs) {
        System.out.println(Math.min(1, 1));
        String s1 = "50";

        String s2 = "62";

        System.out.println(s1.compareTo(s2));
//        String[] strings = {"dog", "in", "ending", "a", "and"};

        String[] strings = {"dog", "in"};


        Arrays.sort(strings, new LengthComparator());

        for (String str : strings) {
            System.out.println(str);
        }
    }
}
