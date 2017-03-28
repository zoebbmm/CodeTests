package AlgorithmAndDataStructureTests.LeetCode.Microsoft.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 11/6/16.
 */
public class Main {

    public static void main(String[] agrs) {

        String[] str = new String[]{"A", "B", "C", "AA", "ABB"};

        List<Integer> result = convert(str);

        for(int i : result) {
            System.out.println(i);
        }

    }

    public static List<Integer> convert(String[] list) {
        List<Integer> result = new ArrayList<>();

        for (String str : list) {
            result.add(titleToNumber(str));
        }

        return result;
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result  = 0;

        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }

        return result;
    }
}
