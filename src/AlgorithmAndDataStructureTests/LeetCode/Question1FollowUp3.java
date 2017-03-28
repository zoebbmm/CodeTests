package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by weizhou on 7/18/16.
 */
public class Question1FollowUp3 {
    public static void main(String[] args) {
        System.out.println(wordPatternMatch("abab", "redblueredblue"));
        System.out.println(wordPatternMatch("aaaa", "redredredred"));
        System.out.println(wordPatternMatch("aabb", "xyzabcxzyabc"));


    }

    public static boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    private static boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            // create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(c);
            set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }

    public static boolean wordPatternMatchCP(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) {
            return true;
        }

        if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) {
            return false;
        }

        Map<Character, String> forwardMap = new HashMap<>();
        Map<String, Character> invertedMap = new HashMap<>();

        return wordPatternMatchHelper(0, pattern, 0, str, forwardMap, invertedMap);
    }

    private static boolean wordPatternMatchHelper(int pStart, String pattern,
                                           int sStart, String str,
                                           Map<Character, String> forwardMap,
                                           Map<String, Character> invertedMap) {
        if (pStart == pattern.length() && sStart == str.length()) {
            return true;
        }

        if (pStart >= pattern.length() || sStart >= str.length()) {
            return false;
        }

        char pChar = pattern.charAt(pStart);
        for (int i = sStart; i < str.length(); i++) {
            String curr = str.substring(sStart, i + 1);

            if ((!forwardMap.containsKey(pChar)) && (!invertedMap.containsKey(curr))) {
                forwardMap.put(pChar, curr);
                invertedMap.put(curr, pChar);

                if (wordPatternMatchHelper(pStart + 1, pattern, i + 1,
                        str, forwardMap, invertedMap)) {
                    return true;
                }

                forwardMap.remove(pChar);
                invertedMap.remove(curr);
            } else if (forwardMap.containsKey(pChar) && invertedMap.containsKey(curr)) {
                String dict = forwardMap.get(pChar);
                char pCharDict = invertedMap.get(curr);

                // IMPORTANT !! If not equal, instead of returnning false immedidately,
                // We need to try other longer substrings.
                if (!dict.equals(curr) || pCharDict != pChar) {
                    continue;
                }

                if (wordPatternMatchHelper(pStart + 1, pattern, i + 1, str,
                        forwardMap, invertedMap)) {
                    return true;
                }
            }
        }

        return false;
    }
}
