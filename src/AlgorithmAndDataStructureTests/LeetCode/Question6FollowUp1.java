package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weizhou on 10/9/16.
 */
public class Question6FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(longestPalindrome("abccccdd"));

        System.out.println(longestPalindrome("Aa"));

        System.out.println(longestPalindrome("abfccccdd"));


    }


    public static int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int odd = set.size();
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }
}
