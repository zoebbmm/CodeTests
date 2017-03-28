package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question127FollowUp3 {
    public int find1stNonRepeat(String str) {
        if (str.isEmpty()) return -1;

        int[] count = new int[26];

        for (int i = 0; i <str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
