package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/9/16.
 */
public class Question71 {
    public int lastRemaining(int n) {
        int rest = n, start = 1, step = 2;
        boolean left = true;
        while (rest > 1) {
            rest /= 2;
            if (left) start = start + step * rest - step / 2;
            else start = start - step * rest + step / 2;
            step *= 2;
            left = !left;
        }
        return start;
    }
}
