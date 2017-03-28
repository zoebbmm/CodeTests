package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question29 {
    public static void main(String[] args) {
        String str = "aab";

        List<List<String>> lists = findAllSubPalidromes(str);

        for(List<String> list : lists) {
            for(String string : list) {
                System.out.print(string + " , ");
            }

            System.out.println();
        }
    }

    public static List<List<String>> findAllSubPalidromes(String str) {
        if (str == null || str.length() == 0) return null;

        List<List<String>> lists = new ArrayList<>();
        List<String> currentList = new ArrayList<>();

        impl(str, currentList, lists, 0);

        return lists;
    }

    private static void impl(String str, List<String> currentList, List<List<String>> lists, int start) {
        if (start == str.length()) {
            lists.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = start + 1; i <= str.length(); i++) {
            String sub = str.substring(start, i);

            if (isPalindrome(sub)) {
                currentList.add(sub);
                impl(str, currentList, lists, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static Boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
