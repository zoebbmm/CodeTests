package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question93 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num > 1 && num % 2 == 0) {
            num /= 2;
        }

        while (num > 1 && num % 3 == 0) {
            num /= 3;
        }

        while (num > 1 && num % 5 == 0) {
            num /= 5;
        }

        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }
}
