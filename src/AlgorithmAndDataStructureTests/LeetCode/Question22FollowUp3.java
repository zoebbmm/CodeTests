package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question22FollowUp3 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;

        while (m != n) {
            shift++;
            m = m >> 1;
            n = n >> 1;
        }

        return m << shift;
    }
}
