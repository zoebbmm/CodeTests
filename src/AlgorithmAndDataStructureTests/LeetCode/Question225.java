package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/29/16.
 */
public class Question225 {
    public static void main(String[] agrs){
        System.out.println(canConstruct("aab", "aba"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aa"));
        System.out.println(canConstruct("aa", "a"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(arr[ransomNote.charAt(i) - 'a'] <= 0) {
                return false;
            } else {
                arr[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
