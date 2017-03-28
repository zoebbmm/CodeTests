package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question86FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(pow(2, 5));
    }
    public static double pow(double x, int n) {
        if (n < 0) {
            return 1 / powHelper(x, -n);
        } else {
            return powHelper(x, n);
        }
    }

    private static double powHelper(double x, int n) {
        if (n == 0) return 1;

        double v = powHelper(x, n/2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
}
