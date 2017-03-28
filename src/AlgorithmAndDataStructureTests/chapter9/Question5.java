package AlgorithmAndDataStructureTests.chapter9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/8/16.
 */
public class Question5 {
    public static void main(String[] args) {
        String str = "abc";

        char[] chars = str.toCharArray();

        List<String> stringList = permutations(chars);

        for(String string : stringList) {
            System.out.println(string);
        }

    }

    // Time - O(n!)
    public static List<String> permutations(char[] chars) {
        List<List<Character>> lists = new ArrayList<>();

        List<Character> currentList = new ArrayList<>();

        findPermutations(chars, currentList, lists);

        List<String> stringList = new ArrayList<>();

        for (List<Character> list : lists) {
            String str = new String();

            for (Character character : list) {
                str += character;
            }

            stringList.add(str);
        }

        return stringList;
    }

    private static void findPermutations(char[] chars, List<Character> currentList, List<List<Character>> lists) {
        if (currentList.size() == chars.length) {
            lists.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (currentList.contains(chars[i])) continue;

            currentList.add(chars[i]);
            findPermutations(chars, currentList, lists);
            currentList.remove(currentList.size() - 1);
        }

        return;
    }
}
