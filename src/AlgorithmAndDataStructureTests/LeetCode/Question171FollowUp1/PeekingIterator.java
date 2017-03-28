package AlgorithmAndDataStructureTests.LeetCode.Question171FollowUp1;

import java.util.Iterator;

/**
 * Created by weizhou on 8/24/16.
 */
public class PeekingIterator implements Iterator<Integer>{
    private Iterator<Integer> it;
    private int peakElement;
    private boolean peaked;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        peakElement = 0;
        peaked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!peaked) {
            peakElement = it.next();
            peaked = true;
        }
        return peakElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ans = 0;
        if (peaked) {
            ans = peakElement;
            peaked = false;
        } else {
            ans = it.next();
        }

        return ans;
    }

    @Override
    public boolean hasNext() {
        return peaked == true || it.hasNext();
    }
}
