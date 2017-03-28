package AlgorithmAndDataStructureTests.LeetCode;

import java.math.BigInteger;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question91FollowUp4 {
    public static void main(String[] agrs) {
        System.out.println(isAdditiveNumberSolution1("10010110"));
        System.out.println(isAdditiveNumberSolution1("112358"));
        System.out.println(isAdditiveNumberSolution1("113"));
        System.out.println(isAdditiveNumberSolution1("1203"));
        System.out.println(isAdditiveNumberSolution1("0235"));


    }


    public static boolean isAdditiveNumberSolution1(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++)
            for (int j = 1; Math.max(j, i) <= n - i - j; j++)
                if (isValid(i, j, num)) return true;
        return false;
    }
    private static boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }

    public boolean isAdditiveNumberLarger(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }
    private boolean isValidLarger(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
