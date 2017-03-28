package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question91FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(divide(16, 3));

        System.out.println(divide(15, 3));

    }
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;

        boolean isNeg = false;
        if ((dividend > 0 && divisor < 0) ||
                (dividend < 0 && divisor > 0))
            isNeg = true;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int ans = 0;

        while (a >= b) {
            Long tempDivisor = b;
            int shift = 0;
            while (a >= tempDivisor) {
                tempDivisor <<= 1;
                shift++;
            }

            ans += (1 << (shift - 1));
            a -= b << (shift - 1);
        }

        if (isNeg) ans = -ans;
        return ans;
    }
}
