package AlgorithmAndDataStructureTests.chapter11;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by weizhou on 7/9/16.
 */
public class Question2 {
    public void sortStringsAsAnagram(String[] arr) {
        Hashtable<String, LinkedList<String>> table = new Hashtable<>();

        for (String str : arr) {
            String sortedString = sortString(str);

            if (!table.containsKey(sortedString)) {
                table.put(sortedString, new LinkedList<String>());
            }

            LinkedList<String> currentList = table.get(sortedString);
            currentList.add(str);
        }

        int index = 0;

        for (String key : table.keySet()) {
            LinkedList<String> list = table.get(key);

            for (String str : list) {
                arr[index++] = str;
            }
        }
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}
