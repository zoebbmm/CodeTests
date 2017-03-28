package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question10 {
    public static void main(String[] agrs) {
        System.out.println(findTheDifference("abcd", "abcd"));
    }
    public static char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for(char ch : t.toCharArray()) {
            letters[ch - 'a']++;
        }
        for(char ch : s.toCharArray()) {
            letters[ch - 'a']--;
        }

        for(int i = 0; i < letters.length; i++) {
            if(letters[i] != 0) {
                return (char)(i + 'a');
            }
        }
        return 0;
    }
}
