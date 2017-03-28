package AlgorithmAndDataStructureTests.chapter17;

import java.util.Hashtable;
import java.util.Random;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question9 {
    public int findOccurenceOfGivenWord(String[] book) {
        Hashtable<String, Integer> cachedWordsFrequencies = preProcessing(book);

        String targetWord = book[new Random().nextInt(book.length)];
        int frequencyOfGivenWord = findFrequences(book, targetWord, cachedWordsFrequencies);

        return frequencyOfGivenWord;
    }

    private Hashtable<String, Integer> preProcessing(String[] book) {
        Hashtable<String, Integer> table = new Hashtable<>();

        for (String word : book) {

            String formattedWord = word.toLowerCase().trim();

            if (!word.isEmpty()) {
                if (!table.containsKey(formattedWord)) {
                    table.put(formattedWord, 0);
                } else {
                    table.put(formattedWord, table.get(formattedWord) + 1);
                }
            }
        }

        return table;
    }

    private int findFrequences(String[] book, String targetWord, Hashtable<String, Integer> table) {
        for(String word : book) {
            String formattedWord = word.toLowerCase().trim();

            if (formattedWord.equals(targetWord)) {
                return table.get(formattedWord);
            }
        }

        return -1;
    }
}
