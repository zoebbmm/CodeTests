package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question86FollowUp2 {
    public static void main(String[] agrs) {
        System.out.println(isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count == 1;
    }
    public boolean isPowerOfTwoOneLineSolution(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
