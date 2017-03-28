package AlgorithmAndDataStructureTests.LeetCode.Question263;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weizhou on 12/7/16.
 */
public class HitCounter {
    Queue<Integer> q = null;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}
