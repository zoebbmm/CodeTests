package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 8/12/16.
 */
public class Question69 {
    public static void main(String[] agrs) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

    public static String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), 0);

            if (dict.containsKey(T.charAt(i))) {
                dict.put(T.charAt(i), dict.get(T.charAt(i)) + 1);
            } else {
                dict.put(T.charAt(i), 1);
            }
        }

        int start = 0;
        int count = 0;
        int minLen = S.length() + 1;
        String result = "";

        for (int end = 0; end < S.length(); end++) {
            if (map.containsKey(S.charAt(end))) {
                map.put(S.charAt(end), map.get(S.charAt(end)) + 1);

                if (map.get(S.charAt(end)) <= dict.get(S.charAt(end))) {
                    count++;
                }
            }

            if (count == T.length()) {
                while (!dict.containsKey(S.charAt(start)) ||
                        map.get(S.charAt(start)) > dict.get(S.charAt(start))) {
                    if (map.containsKey(S.charAt(start))) {
                        map.put(S.charAt(start), map.get(S.charAt(start)) -1);
                    }
                    start++;
                }

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result = S.substring(start, end + 1);
                }
            }
        }

        return result;
    }
}
