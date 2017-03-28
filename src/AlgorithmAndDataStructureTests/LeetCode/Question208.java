package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question208 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            int start = i;
            for (j = 0; j < needle.length(); j++) {
                if (start < haystack.length() && haystack.charAt(start) == needle.charAt(j)) {
                    start++;
                } else {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
