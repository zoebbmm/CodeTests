package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question191 {
    public static void main(String[] agrs) {
        int[][] envelops = new int[4][2];

        envelops[0][0] = 5;
        envelops[0][1] = 4;
        envelops[1][0] = 6;
        envelops[1][1] = 4;
        envelops[2][0] = 6;
        envelops[2][1] = 7;
        envelops[3][0] = 2;
        envelops[3][1] = 3;

        System.out.println(maxEnvelopes(envelops));

    }
    //State: Sort envelopes' width, f[i] is maximum number of envelopes number i envelope can get;
    //Function: f[i] = Math.max(f[i - k] + 1) if Size(i - k) < size(i);
    //Initialize: f[i] = 1;
    //Result: Max(f[i]);
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        //按信封的width先排个序，方便后面的计算
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });

        int[] f = new int[envelopes.length];
        //这里所有的一个信封都可以独立地表示包含一个信封，所以初始化值为1
        Arrays.fill(f, 1);
        int result = 0;
        for (int i = 1; i < envelopes.length; i++) {
            for (int k = i - 1; k >= 0; k--) {
                //因为array.sort后，还会存在width相同的情况，所以操作之前要先判断width是不是严格小于现有的信封
                if (envelopes[k][0] < envelopes[i][0] && envelopes[k][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[k] + 1);
                }
            }
            result = Math.max(result, f[i]);
        }

        return result;
    }
}
