package AlgorithmAndDataStructureTests.LeetCode.Question223;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by weizhou on 8/29/16.
 */
public class SummaryRanges {
    TreeSet<Interval> set;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new TreeSet<Interval>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
    }

    public void addNum(int val) {
        Interval t = new Interval(val, val);

        Interval floor = set.floor(t);
        if(floor!=null){
            if(val<=floor.end){
                return;
            }else if(val == floor.end+1){
                t.start = floor.start;
                set.remove(floor);
            }
        }

        Interval ceil = set.higher(t);
        if(ceil!=null){
            if(ceil.start==val+1){
                t.end = ceil.end;
                set.remove(ceil);
            }
        }

        set.add(t);
    }


    public List<Interval> getIntervals() {
        return Arrays.asList(set.toArray(new Interval[0]));
    }
}
