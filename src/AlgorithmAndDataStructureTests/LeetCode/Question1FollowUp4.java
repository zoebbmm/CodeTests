package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/26/16.
 */
public class Question1FollowUp4 {
    public static void main(String[] agrs) {
        String s = "ABAB";

        System.out.println(characterReplacement(s, 2));

        String s1 = "AABAABA";

        System.out.println(characterReplacement(s1, 1));

        String s2 = "ABBCDDD";

        System.out.println(characterReplacement(s2, 2));

    }

    /*
    The whole idea is that if we have a string of length N out of which M characters are same,
    we can replace (N - M) characters to get a continueous string of N characters.
    If (N - M) <= K. N is the local maximum for this window.
    If this length is greater than K. Slide the window.
    */
    public static int characterReplacement(String s, int k) {
        int[] charCount = new int[26];

        int left, right, maxCount, maxLen;
        left = right = maxCount = maxLen = 0;

        while(right < s.length()){
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
            if(right - left + 1 - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }
        return maxLen;
    }
}
