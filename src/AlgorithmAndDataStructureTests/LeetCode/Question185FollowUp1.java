package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question185FollowUp1 {

    public static void main(String[] agrs) {
//        getAnagramIndices("abdcghbaabcdij", "bcda");
        getAnagramIndices("bbbababaaabbbb", "ab");

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] arr = str.toCharArray();

            Arrays.sort(arr);

            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }

    public static List<Integer> getAnagramIndices(String haystack, String needle) {
        // WRITE YOUR CODE HERE

        List<Integer> result = new ArrayList<>();

        if (needle == null || haystack == null || needle.length() == 0 || haystack.length() == 0) {
            return result;
        }


        List<String> anagramList = new ArrayList<>();
        anagramList.add(needle);

        List<Character> currentList = new ArrayList<>();

        char[] arr = needle.toCharArray();

        permutations(arr, currentList, anagramList);

        int i = 0;
        int len = needle.length();

        while (i < haystack.length() - len) {
            String sub = haystack.substring(i, i + len);

            if (anagramList.contains(sub)) {
                result.add(i);
            }

            i++;
        }

        for (int idx : result) {
            System.out.println(idx);
        }

        return result;
    }

    private static void permutations(char[] arr, List<Character> currentList, List<String> anaramList) {
        if (currentList.size() == arr.length) {
            StringBuilder sb = new StringBuilder();

            for (char c : currentList) {
                sb.append(c);
            }

            anaramList.add(sb.toString());
        }

        for (int i = 0; i < arr.length; i++) {
            if (currentList.contains(arr[i])) continue;

            currentList.add(arr[i]);
            permutations(arr, currentList, anaramList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
