package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question38FollowUp2 {
    public static void main(String[] agrs) {
        String str = "aabbbbbceeedd";

        System.out.println(longestSubstringTwoDistinctCharacters(str));
    }

    public static String longestSubstringTwoDistinctCharacters(String s) {
        if(s.length() < 1) return null;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        String maxString = "";
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }

            String current = s.substring(lo, hi);

            if (current.length() > maxString.length()) {
                maxString = current;
            }
        }

        System.out.println(maxString);
        return maxString;
    }

}
