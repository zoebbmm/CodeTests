package AlgorithmAndDataStructureTests.LeetCode.Question266;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 12/7/16.
 */
public class Logger {
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && timestamp - map.get(message) < 10)
            return false;
        map.put(message, timestamp);
        return true;
    }
}
