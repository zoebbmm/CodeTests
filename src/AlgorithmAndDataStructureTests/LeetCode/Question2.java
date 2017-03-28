package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question2 {
    public int findStartPosOfLongestRepeatedCharacter(String str) {
        if (str.isEmpty()) return -1;

        if (str.length() == 1) return 0;

        int runner = 1;
        int currentPos = 0;
        int currentCount = 0;
        int largestCount = Integer.MIN_VALUE;
        int repeatedStartPos = 0;

        while (runner < str.length() && currentPos < str.length()) {
            if (str.charAt(currentPos) == str.charAt(runner)) {
                currentCount++;
                runner++;

                if (currentCount > largestCount) {
                    largestCount = currentCount;
                    repeatedStartPos = currentPos;
                }
            } else {
                currentCount = 0;
                currentPos = runner;
                runner++;
            }
        }

        return repeatedStartPos;
    }
}
