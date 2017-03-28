package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question13 {
    public int maxOccurence(String s) {
        char[] chars = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > max) {
                max = map.get(s.charAt(i));
            }
        }

        return max;
    }
}
