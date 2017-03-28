package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question91FollowUp5 {
    public int addDigitsOn(int num) {
        if (num < 10) {
            return num;
        }

        int result = num;

        while (result >= 10) {
            // Get each didgit of the number
            int digit = 0;
            while (result > 0) {
                digit += result % 10;
                result /= 10;
            }

            result = digit;
        }

        return result;
    }

    public int addDigits(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }
}
