package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question127FollowUp2 {
    public static void main(String[] args) {

        String str = "abcabcdbb";

        System.out.println(lengthOfLongestSubstring(str));

        String str1 = "abcad";

        System.out.println(lengthOfLongestSubstring(str1));
    }

    public static int lengthOfLongestSubstring(String s) {
        // if the string is empty or has only one character
        if (s.length() < 2) return s.length();

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int j = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), i);
            } else {
                maxLen = Math.max(maxLen, i - j);

                for (int k = j; k < i; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        j = k + 1;
                        break;
                    }
                }
            }
        }
        return Math.max(maxLen, s.length() - j);
    }
}
