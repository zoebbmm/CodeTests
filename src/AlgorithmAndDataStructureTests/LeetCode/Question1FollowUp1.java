package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question1FollowUp1 {
    public static void main(String[] agrs) {
        String result = replacePatternWithX("abcdeabcabc", "abc");

        System.out.println(result);
    }
    //Time - O(n)
    //Space - O(n)
    public static String replacePatternWithX(String str, String pattern) {
        char[] recordingChars = new char[str.length()];

        int trackingIndex = 0;

        int recordingIndex = 0;

        while (trackingIndex < str.length()) {
            boolean isMatched = false;

            while (isMatch(str, trackingIndex, pattern)) {
                trackingIndex += pattern.length();
                isMatched = true;
            }

            if (isMatched) {
                recordingChars[recordingIndex] = 'X';
                recordingIndex++;
            }

            if (trackingIndex < str.length()) {
                recordingChars[recordingIndex] = str.charAt(trackingIndex);
                recordingIndex++;
                trackingIndex++;
            }
        }

        return new String(recordingChars);
    }

    private static Boolean isMatch(String str, int start, String pattern) {
        if (start >= str.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (str.charAt(start) != pattern.charAt(i)) {
                return false;
            } else {
                start++;
            }
        }

        return true;
    }
}
