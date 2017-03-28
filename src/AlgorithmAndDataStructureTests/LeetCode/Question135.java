package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question135 {
    public boolean isPalidromeForNumber(int num) {
        if (num < 0) return false;

        int div = 1;

        while (num / div >= 10) {
            div *= 10;
        }

        while (num != 0) {
            int left = num / div;
            int right = num % div;

            if (left != right) {
                return false;
            }

            num = num % div / 10;
            div /= 100;
        }

        return true;
    }
}
