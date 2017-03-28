package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question22FollowUp1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }

        return result;
    }
}
