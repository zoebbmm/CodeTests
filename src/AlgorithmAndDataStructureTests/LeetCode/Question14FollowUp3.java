package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weizhou on 11/3/16.
 */
public class Question14FollowUp3 {
    public boolean canPermutePalindrome(String s) {
        if(s == null) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() <= 1;
    }
}
