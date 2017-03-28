package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question256 {
    public static void main(String[] agrs) {
        int[][] points = new int[3][2];
        points[0] = new int[]{0, 0};
        points[1] = new int[]{1, 0};
        points[2] = new int[]{2, 0};

        System.out.println(numberOfBoomerangs(points));

    }
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);

                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }

            for(int val : map.values()) {
                res += val * (val-1);
            }
            map.clear();
        }

        return res;
    }

    private static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
