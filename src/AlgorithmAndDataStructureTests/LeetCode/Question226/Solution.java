package AlgorithmAndDataStructureTests.LeetCode.Question226;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weizhou on 8/29/16.
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length ==0) {
            return true;
        }

        // Sort according to the start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (isOverlapped(prev, curr)) {
                return false;
            }
            prev = curr;
        }

        return true;
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.end > b.start;
    }
}
