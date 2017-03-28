package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 12/13/16.
 */
public class Question61FollowUp3 {
    public static void main(String[] arg) {
        System.out.println(shortestEncodeString("abbbabbbcabbbabbbc"));
    }


    public static String shortestEncodeString(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[j][i] = i - j;
            }
        }

        Map<String, String> dpMap = new HashMap<>();

        for (int i = 1; i <= len; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                String temp = s.substring(j, i);
                if (dpMap.containsKey(temp)) {
                    dp[j][i] = dpMap.get(temp).length();
                    continue;
                }
                String ans = temp;
                for (int k = j + 1; k <= i; ++k) {
                    String leftStr = s.substring(j, k);
                    String rightStr = s.substring(k, i);
                    if (dp[j][i] > dp[j][k] + dp[k][i]) {
                        dp[j][i] = dp[j][k] + dp[k][i];
                        ans = dpMap.get(leftStr) + dpMap.get(rightStr);
                    }
                    if (checkRepeating(s, j, k, k, i)
                            && (2 + getLength(k - j, i - j) + dp[j][k] < dp[j][i])) {
                        dp[j][i] = 2 + getLength(k - j, i - j) + dp[j][k];
                        ans = String.valueOf((i - j) / (k - j)) + "[" + dpMap.get(leftStr) + "]";
                    }
                }
                dpMap.put(temp, ans);
            }
        }
        return dpMap.get(s);
    }

    public static boolean checkRepeating(String s, int l, int r, int start, int end) {
        if ((end - start) % (r - l) != 0) {
            return false;
        }
        int len = r - l;
        String pattern = s.substring(l, r);
        for (int i = start; i + len <= end; i += len) {
            if (!pattern.equals(s.substring(i, i + len))) {
                return false;
            }
        }
        return true;
    }

    public static int getLength(int plen, int slen) {
        return (int) (Math.log10(slen / plen) + 1);
    }


}
