package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question115 {
    /**
     * Definition for an interval.
     */

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
        Interval interval2 = new Interval(6, 9);

        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);

        Interval newInterval = new Interval(2, 5);

        ArrayList<Interval> result = insert(list, newInterval);

        for(Interval interval : result) {
            System.out.println(interval.start + ", " + interval.end);
        }

//        Interval interval1 = new Interval(1, 2);
//        Interval interval2 = new Interval(3, 5);
//        Interval interval3 = new Interval(6, 7);
//        Interval interval4 = new Interval(8, 10);
//        Interval interval5 = new Interval(12, 16);
//        Interval newInterval = new Interval(4, 9);
//
//        ArrayList<Interval> list = new ArrayList<>();
//        list.add(interval1);
//        list.add(interval2);
//        list.add(interval3);
//        list.add(interval4);
//        list.add(interval5);
//
//        ArrayList<Interval> result = insert(list, newInterval);
//
//        for(Interval interval : result) {
//            System.out.println(interval.start + ", " + interval.end);
//        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);

        return result;
    }
}
