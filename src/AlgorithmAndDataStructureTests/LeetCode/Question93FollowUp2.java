package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question93FollowUp2 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1 || primes == null || primes.length == 0) {
            return 1;
        }

        int k = primes.length;
        int[] index = new int[k];

        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i < n; i++) {
            int curr = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                curr = Math.min(curr, primes[j] * result.get(index[j]));
            }

            result.add(curr);

            // update the index
            for (int j = 0; j < k; j++) {
                if (primes[j] * result.get(index[j]) == curr) {
                    index[j]++;
                }
            }
        }

        return result.get(result.size() - 1);
    }
}
