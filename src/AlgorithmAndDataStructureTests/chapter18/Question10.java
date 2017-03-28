package AlgorithmAndDataStructureTests.chapter18;

import java.util.*;

/**
 * Created by weizhou on 7/12/16.
 */
public class Question10 {
    public LinkedList<String> findPathOfConvetingAWord(Set<String> dictionary, String startWord, String stopWord) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visitedStrings = new HashSet<>();

        Hashtable<String, String> backTrackMap = new Hashtable<>();

        queue.add(startWord);
        visitedStrings.add(startWord);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();

            Set<String> allPossibleEditedWords = getEditWords(currentWord);

            for (String editedWord : allPossibleEditedWords) {
                if (editedWord.equals(stopWord)) {
                    LinkedList<String> resultedList = new LinkedList<>();
                    resultedList.add(editedWord);

                    while (currentWord != null) {
                        resultedList.add(0, currentWord);
                        currentWord = backTrackMap.get(currentWord);
                    }

                    return resultedList;
                }

                if (dictionary.contains(editedWord) && (!visitedStrings.contains(editedWord))) {
                    queue.add(editedWord);
                    visitedStrings.add(editedWord);
                    backTrackMap.put(editedWord, currentWord);
                }
            }
        }

        return null;
    }

    private Set<String> getEditWords(String str) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray();

            char currentCharacter = str.charAt(i);

            for (char c = 'A'; c <= 'Z'; c++) {
                if (c != currentCharacter) {
                    chars[i] = c;
                    set.add(new String(chars));
                }
            }
        }

        return set;
    }
}
