package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question110 {
    public static void main(String[] args) {

    }

    /**
     * Time - O(n ^ 2)
     * Space - O(n ^ 2)
     * @param str
     * @return
     */
    public static int minimumInsertionForPalindrome(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) return 0;

        int[][] table = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                table[i][j] = 0;
            }
        }

        for(int gap = 1; gap < str.length(); gap++) {
            for(int low = 0, high = gap; high < str.length(); low++, high++) {
                if (str.charAt(low) == str.charAt(high)) {
                    table[low][high] = table[low+1][high-1];
                } else {
                    table[low][high] = Math.min(table[low+1][high], table[low][high-1]) + 1;
                }
            }
        }

        return table[0][str.length()-1];
    }
}
