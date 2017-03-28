package AlgorithmAndDataStructureTests.LeetCode.Question214FollowUp1;

/**
 * Created by weizhou on 8/30/16.
 */
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (isBadVersion(lo)) {
            return lo;
        }

        return -1;
    }
}
