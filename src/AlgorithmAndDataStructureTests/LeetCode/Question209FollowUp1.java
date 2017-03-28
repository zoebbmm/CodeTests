package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question209FollowUp1 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1)
            return 0;

        int lo = 0;
        int hi = height.length - 1;
        int max = 0;

        while (lo < hi) {
            max = Math.max(max, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}
