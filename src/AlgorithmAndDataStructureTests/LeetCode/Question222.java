package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question222 {
    /**
     * Time - O(n)
     * Space - O(n)
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }

        Integer[] table = new Integer[]{0, 0, 1, 2, 4, 6, 9};
        List<Integer> result = new ArrayList<>(Arrays.asList(table));

        for (int i = 7; i <= n; i++) {
            result.add(result.get(i - 3) * 3);
        }

        return result.get(n);
    }

    /**
     * Time - O(n)
     * Space - O(1)
     *
     * @param n
     * @return
     */
    public int integerBreakSolution2(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n == 4) {
            return 4;
        }

        if (n % 3 == 0) {
            int numOfThree = n / 3;
            return (int) Math.pow(3, numOfThree);
        } else if (n % 3 == 1) {
            int numOfThree = (n - 1) / 3 - 1;
            int result = (int) Math.pow(3, numOfThree) * 4;
            return result;
        } else {
            int numOfThree = (n - 2) / 3;
            return (int) Math.pow(3, numOfThree) * 2;
        }

    }

}
