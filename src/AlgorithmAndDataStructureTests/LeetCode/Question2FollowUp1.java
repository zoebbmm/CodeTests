package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question2FollowUp1 {
    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> list = findRepeatedDnaSequences(str);

        for (String string : list) {
            System.out.println(string);
        }
    }

    //O(N)
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (!map.containsKey(key)) map.put(key, 1);
            else {
                map.put(key, map.get(key) + 1);
                if (map.get(key) == 2) res.add(key); // add substring only if it appears at second time;
            }
        }
        return res;
    }
}
