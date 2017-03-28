package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question14FollowUp1 {
    public static void main(String[] agrs) {
        Set<String> result = palindromes("abcc");

        for (String str : result) {
            System.out.println(str);
        }
    }

    // Time: O(n^2)
    public static Set<String> palindromes(final String input) {

        final Set<String> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            // expanding even length palindromes:
            expandPalindromes(result,input,i,i+1);
            // expanding odd length palindromes:
            expandPalindromes(result,input,i,i);
        }
        return result;
    }

    public static void expandPalindromes(final Set<String> result, final String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result.add(s.substring(i,j+1));
            i--; j++;
        }
    }
}
