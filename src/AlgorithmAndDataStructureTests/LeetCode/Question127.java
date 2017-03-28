package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question127 {
    public Character find1stNonRepeat(String str) {
        if (str.isEmpty()) return null;

        int[] count = new int[26];

        for (int i = 0; i <str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return null;
    }
}
