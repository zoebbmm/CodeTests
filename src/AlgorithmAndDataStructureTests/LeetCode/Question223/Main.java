package AlgorithmAndDataStructureTests.LeetCode.Question223;

import java.util.List;

/**
 * Created by weizhou on 8/29/16.
 */
public class Main {
    public static void main(String[] agrs) {
        SummaryRanges summaryRanges = new SummaryRanges();

        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(7);
        summaryRanges.addNum(2);
        summaryRanges.addNum(6);

        List<Interval> result = summaryRanges.getIntervals();

        System.out.println(result.size());

    }
}
