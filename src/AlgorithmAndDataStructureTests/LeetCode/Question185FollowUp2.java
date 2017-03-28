package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 10/29/16.
 */
public class Question185FollowUp2 {
    public static void main(String[] agrs) {
        List<Integer> result = findAnagrams("cbaebabacd", "abc");

        for (int i : result) {
            System.out.println(i);
        }
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[26]; //character hash

        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right) - 'a'] >= 1) {
                count--;
            }

            hash[s.charAt(right) - 'a']--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length()) {
                if (hash[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }

                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return list;
    }
}
