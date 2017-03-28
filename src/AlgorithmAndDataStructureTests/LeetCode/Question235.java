package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question235 {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();

        while (true) {
            int square = getSumOfSquare(n);

            if (square == 1) {
                return true;
            } else if (set.contains(square)) {
                return false;
            }

            set.add(square);
            n = square;
        }
    }

    private int getSumOfSquare(int n) {
        int result = 0;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            result += digit * digit;
        }

        return result;
    }

    /**
     * Space - O(1)
     * @param n
     * @return
     */
    public int digitSquareSumSolutionV2(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappySolutionV2(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSumSolutionV2(slow);
            fast = digitSquareSumSolutionV2(fast);
            fast = digitSquareSumSolutionV2(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }
}
