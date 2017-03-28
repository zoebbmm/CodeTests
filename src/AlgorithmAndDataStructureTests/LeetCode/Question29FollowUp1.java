package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question29FollowUp1 {
    public int minumCutToPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int cutIndex = 0;
        int rightIndex = str.length();

        int cut = 0;

        while (cutIndex < str.length()) {
            String temp = str.substring(cutIndex, rightIndex);

            if (isPalindrome(temp)) {
                cutIndex = rightIndex;
                rightIndex = str.length();

                if (cutIndex == str.length()) return cut;

                cut++;
            } else {
                rightIndex--;
            }
        }

        return cut;
    }

    private Boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
