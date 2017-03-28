package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question257 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x < min) {
                min = x;
            }
        }
        int count = 0;
        for (int x : nums) {
            count += x - min;
        }
        return count;
    }
}
