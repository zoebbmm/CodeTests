package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question219FollowUp1 {
    public static void main(String[] agrs) {
        List<String> result =findStrobogrammatic(2);

        for (String i : result) {
            System.out.println(i);
        }
    }
    private static List<String> result = new ArrayList<String>();
    private static Map<Character, Character> hashMap = new HashMap<>();

    public static List<String> findStrobogrammatic(int n) {
        result.clear();
        hashMap.clear();
        fillHashMap(hashMap);

        char[] arr = new char[n];
        findStrobogrammaticHelper(arr, 0, n - 1);

        return result;
    }

    private static void findStrobogrammaticHelper(char[] arr, int lo, int hi) {
        if (lo > hi) {
            if (arr.length == 1 || (arr.length > 1 && arr[0] != '0')) {
                result.add(new String(arr));
            }
            return;
        }

        for (Character c : hashMap.keySet()) {
            arr[lo] = c;
            arr[hi] = hashMap.get(c);

            if (lo < hi || (lo == hi && hashMap.get(c) == c)) {
                findStrobogrammaticHelper(arr, lo + 1, hi - 1);
            }
        }
    }

    private static void fillHashMap(Map<Character, Character> hashMap) {
        hashMap.put('0', '0');
        hashMap.put('1', '1');
        hashMap.put('8', '8');
        hashMap.put('6', '9');
        hashMap.put('9', '6');
    }
}
