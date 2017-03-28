package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question6 {
    //Time - O(n)
    public String lengthOfLongestPalidrome(String str) {
        if (str == null || str.length() == 0) return null;

        if (str.length() == 1) return str;

        String longest = str.substring(0, 1);

        for (int i = 0; i < str.length(); i++) {
            String palidrome = expand(str, i, i);

            if (palidrome.length() > longest.length()) {
                longest = palidrome;
            }

            palidrome = expand(str, i, i+1);

            if (palidrome.length() > longest.length()) {
                longest = palidrome;
            }
        }

        return longest;
    }

    private String expand(String str, int index1, int index2) {
        int left = index1;

        int right = index2;

        while (left >= 0 && right < str.length() && (str.charAt(left) == str.charAt(right))) {
            left--;
            right++;
        }

        return str.substring(left+1, right);
    }
}
