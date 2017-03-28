package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question14FollowUp2 {
    public boolean isPalidromeSingleString(String str) {
        if (str == null || str.length() == 0) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;

        }

        return true;
    }
}
