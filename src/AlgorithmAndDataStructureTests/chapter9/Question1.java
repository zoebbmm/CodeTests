package AlgorithmAndDataStructureTests.chapter9;

/**
 * Created by weizhou on 7/7/16.
 */
public class Question1 {
    public int countWays(int n) {
        int[] map = null;
        return countWaysDynamicProgramming(n, map);
    }

    private int countWaysDynamicProgramming(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] >= 0) {
            return map[n];
        } else {
            map[n] = countWaysDynamicProgramming(n - 1, map) +
                    countWaysDynamicProgramming(n - 2, map) +
                    countWaysDynamicProgramming(n - 3, map);

            return map[n];
        }
    }
}
