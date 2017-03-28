package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question127FollowUp1 {
    public Character find1stRepeat(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                return str.charAt(i);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        return null;
    }
}
