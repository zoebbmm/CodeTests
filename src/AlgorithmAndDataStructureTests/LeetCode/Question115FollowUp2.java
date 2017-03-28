package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 10/31/16.
 */
public class Question115FollowUp2 {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] agrs) {
        Interval interval1 = new Interval(3, 4);
        Interval interval2 = new Interval(2, 3);
        Interval interval3 = new Interval(1, 2);

        Interval[] intervals = new Interval[]{interval1, interval2, interval3};
        int[] result = findRightInterval(intervals);

        for (int i : result) {
            System.out.println(i);
        }

        Interval interval4 = new Interval(1, 4);
        Interval interval5 = new Interval(2, 3);
        Interval interval6 = new Interval(3, 4);

        Interval[] intervals1 = new Interval[]{interval4, interval5, interval6};
        int[] result1 = findRightInterval(intervals1);

        for (int i : result1) {
            System.out.println(i);
        }
    }

    public static int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0];
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);

        //put interval and the index together in map
        Map<Interval, Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        //sort intervals accordig to start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });


        //after sort, use binary seach to find the minimum right interval, don't update result if right interval does not exist
        for(int i = 0; i < intervals.length; i++) {
            int start = i + 1, end = intervals.length - 1;
            while(start < end) {
                int mid = (start + end) / 2;
                if(intervals[i].end > intervals[mid].start) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if(intervals[i].end <= intervals[end].start)
                res[map.get(intervals[i])] = map.get(intervals[end]);
        }

        return res;
    }
}
