package AlgorithmAndDataStructureTests.chapter18.Question7;

import GenericConceptTests.TestComparator.LengthComparator;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by weizhou on 7/12/16.
 */
public class Question7 {
    public String findLongestStringComposedOfOtherWords(String[] strings) {
        Hashtable<String, Boolean> cache = new Hashtable<>();

        for (String str : strings) {
            cache.put(str, true);
        }

        Arrays.sort(strings, new LengthComparator());

        for (String str : strings) {
            if (canBuildWord(str, true, cache)) {
                return str;
            }
        }

        return "";
    }

    private Boolean canBuildWord(String str, Boolean isOriginalWord, Hashtable<String, Boolean> cache) {
        if (cache.containsKey(str) && !isOriginalWord) {
            return cache.get(str);
        }

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);

            if (cache.containsKey(left) && (cache.get(left) == true) && canBuildWord(right, false, cache)) {
                return true;
            }
        }

        cache.put(str, false);
        return false;
    }
}
