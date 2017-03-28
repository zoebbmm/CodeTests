package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question115FollowUp1 {
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
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(8, 10);
        Interval interval3 = new Interval(2, 6);
        Interval interval4 = new Interval(15, 18);

        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);

        List<Interval> result = merge(list);

        for(Interval interval : result) {
            System.out.println(interval.start + ", " + interval.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if(intervals==null||intervals.size()==0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;
            }
        });

        Interval pre = intervals.get(0);

        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }
}
