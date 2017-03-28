package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/10/16.
 */
public class Question237FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(validWordAbbreviation("apple", "a3e"));
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));


    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, m = word.length(), n = abbr.length();
        while (i < m && j < n) {
            if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                if (abbr.charAt(j) == '0') return false;
                int val = 0;
                while (j < n && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    val = val * 10 + abbr.charAt(j) - '0';
                    j++;
                }

                i += val;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return i == m && j == n;
    }
}
