package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question36 {
    public int reverse(int x) {
        if (x < 10 && x > -10) return x;
        long result = 0;
        boolean neg = false;

        // consider the negative case
        if (x < 0) {
            neg = true;
            x= -x;
        }

        while (x > 0) {
            int digit = x % 10;
            x = x / 10;

            result = result * 10 + digit;
        }

        if (neg) result = -result;

        // handle the overflow issue
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}
