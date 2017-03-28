package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question110FollowUp1 {
    public static void main(String[] args) {
//        System.out.println(shortestPalindromeCP("abcd"));
        System.out.println(shortestPalindromeCP("aacecaaa"));
//        System.out.println(shortestPalindromeCP("aba"));
//
//        System.out.println(shortestPalindromeSolution2("abcd"));
//        System.out.println(shortestPalindromeSolution2("aacecaaa"));
//        System.out.println(shortestPalindromeSolution2("aba"));


    }

    public static String shortestPalindromeCP(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindromeCP(s.substring(0, j)) + suffix;
    }

    public static String shortestPalindromeSolution2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        // Step 1: find the longest palindromic substring including s.charAt(0)
        for (int i = 0; i < s.length(); i++) {
            // Odd
            int p = i - 1;
            int q = i + 1;
            int len = 1;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                len += 2;
                p--;
                q++;
            }

            if (p == -1 && len > maxLen) {
                maxLen = len;
            }

            // Even
            p = i;
            q = i + 1;
            len = 0;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
                len += 2;
            }

            if (p == -1 && len > maxLen) {
                maxLen = len;
            }
        }

        int j = maxLen;
        StringBuffer sb = new StringBuffer();
        for (int m = s.length() - 1; m >= j; m--) {
            sb.append(s.charAt(m));
        }

        sb.append(s);

        return sb.toString();
    }
}
