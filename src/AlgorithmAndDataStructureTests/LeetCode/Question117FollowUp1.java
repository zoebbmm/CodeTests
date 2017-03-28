package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 10/16/16.
 */
public class Question117FollowUp1 {

    public static void main(String[] agrs) {
        List<String> result = fizzBuzz(15);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);

            if (i %15 == 0) {
                num = "FizzBuzz";
            } else if (i % 3 == 0) {
                num = "Fizz";
            } else if (i % 5 == 0) {
                num = "Buzz";
            }

            result.add(num);
        }

        return result;
    }
}
