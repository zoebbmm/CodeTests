package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question11FollowUp1 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";

        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(isInterleave(s1, s2, s4));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null || s2==null || s3==null) return false;

        if (s1.length()==0 && s2.length()==0 && s3.length()==0) return true;

        if ((s1.length()+s2.length())!=s3.length()) return false;

        boolean valid[] = new boolean[s2.length()+1];

        valid[0] = false;

        for (int j=1; j<=s2.length(); j++){
            if (s2.charAt(j-1)==s3.charAt(j-1)) valid[j]=true;
        }

        for (int i=1; i<=s1.length(); i++){
            if (s1.charAt(i-1)==s3.charAt(i-1)) valid[0]=true;
            for (int j=1; j<=s2.length(); j++){
                valid[j] = (valid[j] && s1.charAt(i-1)==s3.charAt(i+j-1)) ||
                        (valid[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }

        return valid[s2.length()];
    }

    /**
     * 1st basic version of solution
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveBasic(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else break;
        }

        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else break;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
