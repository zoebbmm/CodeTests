package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question86FollowUp3 {
    public boolean isPerfectSquare(int num) {
        long start = 1, end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long t = mid * mid;
            if (t == num) return true;
            else if (t < num) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
