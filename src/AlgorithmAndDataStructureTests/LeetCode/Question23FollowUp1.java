package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question23FollowUp1 {
    public int romanToInteger(String roman) {
        int[] romanIntegers = {1000, 500, 100, 50, 10, 5, 1};

        String[] romanStrings = {"M", "D", "C", "L", "X", "V", "I"};

        if (roman.length() == 0) return -1;

        for (int i = 0; i < romanStrings.length; i++) {
            int romanPos = roman.indexOf(romanStrings[i]);

            if (romanPos >= 0) {
                return romanIntegers[i] + romanToInteger(roman.substring(romanPos + 1));
            }
        }

        return -1;
    }
}
