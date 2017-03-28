package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 9/23/16.
 */
public class Question177 {
    public static void main(String[] agrs) {
        List<String> result = readBinaryWatch(2);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
