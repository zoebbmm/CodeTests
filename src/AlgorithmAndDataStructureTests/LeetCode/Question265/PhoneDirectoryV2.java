package AlgorithmAndDataStructureTests.LeetCode.Question265;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by weizhou on 12/7/16.
 */
public class PhoneDirectoryV2 {
    private Set<Integer> _used;
    private Queue<Integer> _unused;
    private int _limit;
    private int _maxNumbers;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectoryV2(int maxNumbers) {
        _used = new HashSet<>();
        _unused = new LinkedList<>();
        _maxNumbers = maxNumbers;
        _limit = 0;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int minAvailable = -1;
        if (!_unused.isEmpty()) {
            minAvailable = _unused.poll();
        } else if (_limit < _maxNumbers) {
            minAvailable = _limit;
            _limit++;
        }

        if (minAvailable != -1) {
            _used.add(minAvailable);
        }

        return minAvailable;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !_used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!check(number)) {
            _used.remove(number);
            _unused.offer(number);
        }
    }
}
