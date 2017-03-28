package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/14/16.
 */
public class Question174 {
    public static void main(String[] args) {
        System.out.println(isMatch("a", ".*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("a", "a."));
        System.out.println(isMatch("aab", "a*b"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("acdd", "acb*dd"));

        System.out.println("**********************************");

        System.out.println(isMatchDP("a", ".*"));
        System.out.println(isMatchDP("aa", "a*"));
        System.out.println(isMatchDP("a", "a."));
        System.out.println(isMatchDP("aab", "a*b"));
        System.out.println(isMatchDP("ab", ".*"));
        System.out.println(isMatchDP("acdd", "acb*dd"));


    }

    /**
     * PREFER
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatchDP(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        int rows = s.length();
        int cols = p.length();

        boolean[][] dp = new boolean[rows + 1][cols + 1];
        dp[0][0] = true;

        for (int j = 1; j <= cols; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar != '*') {
                    if (sChar == pChar || pChar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rows][cols];
    }

    public static boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }

        // Case 1: p.length() == 1
        if (p.length() == 1) {
            if (s == null || s.length() == 0) {
                return false;
            }

            if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                return false;
            }

            return isMatch(s.substring(1), p.substring(1));
        }

        // Case 2: p.charAt(1) != '*'
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }

            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else { // case 3
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }

            return false;
        }
    }

//    public static boolean isMatchDP(String s, String p) {
//        if (p == null || p.length() == 0) {
//            return s == null || s.length() == 0;
//        }
//        int rows = s.length();
//        int cols = p.length();
//
//        boolean[][] dp = new boolean[rows + 1][cols + 1];
//        dp[0][0] = true;
//
//        for (int j = 1; j <= cols; j++) {
//            if (p.charAt(j - 1) == '*') {
//                dp[0][j] = dp[0][j - 2];
//            }
//        }
//
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//                char sChar = s.charAt(i - 1);
//                char pChar = p.charAt(j - 1);
//
//                if (pChar != '*') {
//                    if (sChar == pChar || pChar == '.') {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                } else {
//                    if (sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
//                        dp[i][j] = dp[i][j - 2];
//                    } else {
//                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
//                    }
//                }
//            }
//        }
//        return dp[rows][cols];
//    }
}
