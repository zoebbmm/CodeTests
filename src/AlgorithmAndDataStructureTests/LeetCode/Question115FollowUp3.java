package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 10/31/16.
 */
public class Question115FollowUp3 {
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
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(2, 3);
        Interval interval3 = new Interval(1, 3);
        Interval interval4 = new Interval(3, 4);

        Interval[] intervals = new Interval[]{interval1, interval2, interval3, interval4};

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,(o1, o2)->(o1.start)-(o2.start));

        int count=0,j=0;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[j].end>intervals[i].start){
                j=intervals[i].end<intervals[j].end?i:j;
                count++;
            }else {
                j = i;
            }

        }
        return count;
    }
}
