package AlgorithmAndDataStructureTests.LeetCode.Question244;

import java.util.Random;

/**
 * Created by weizhou on 12/7/16.
 */
public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0; // to record how many targets in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            /**
             For the nth target, ++count is n. Then the probability that rnd.nextInt(++count)==0 is 1/n. Thus, the probability that return nth target is 1/n.
             For (n-1)th target, the probability of returning it is (n-1)/n * 1/(n-1)= 1/n.
             */
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
}
