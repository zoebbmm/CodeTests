package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question86FollowUp5 {
    public boolean isPowerOfThree1stSolution(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
