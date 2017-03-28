package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question230 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 1) {
            return result;
        }

        List<Integer> curr = new ArrayList<>();

        getFactorsHelper(2, 1, n, curr, result);

        return result;
    }

    private void getFactorsHelper(int start, int product, int n, List<Integer> curr, List<List<Integer>> result) {
        if (start > n || product > n) {
            return;
        }

        if (product == n) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = start; i < n; i++) {
            if (i * product > n) {
                break;
            }

            if (n % (product * i) == 0) {
                curr.add(i);
                getFactorsHelper(i, product * i, n, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
