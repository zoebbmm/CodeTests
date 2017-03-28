package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question218 {
    public int countDigitOne(int n) {
        int count = 0;
        for (long base = 1; base <= n; base *= 10) {
            long q = n/base, r = n%base;
            count += (q+8) / 10 * base + (q%10 == 1 ? r+1 : 0);
        }
        return count;
    }
}
