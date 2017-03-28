package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question115Followup4 {
    public static void main(String[] agrs) {
        int[][] points = new int[4][2];
        points[0] = new int[]{10, 16};
        points[1] = new int[]{2, 8};
        points[2] = new int[]{1, 6};
        points[3] = new int[]{7, 12};

        System.out.println(findMinArrowShots(points));

    }
    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1) return 0;
        Arrays.sort(points, (a, b)->(a[0]-b[0]));
        int result = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            if(points[i][0] > end) {
                result ++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return result;
    }
}
