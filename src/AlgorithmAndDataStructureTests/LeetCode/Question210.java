package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question210 {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int samePoints = 0;
            double slope = 0;
            int localMax = 1;
            for (int j = i + 1; j < points.length; j++) {
                // check if point i and j are the same
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                    continue;
                } else if (points[i].y == points[j].y) {
                    slope = 0.0;
                } else if (points[i].x == points[j].x) {
                    slope = (double) Integer.MAX_VALUE;
                } else {
                    slope = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                }


                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }
            for (Integer num : map.values()) {
                localMax = Math.max(localMax, num);
            }
            localMax += samePoints;
            max = Math.max(max, localMax);
        }
        return max;
    }
}
