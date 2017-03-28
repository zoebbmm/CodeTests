package AlgorithmAndDataStructureTests.chapter18;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question5 {
    public int findShortestDistance(String[] words, String word1, String word2) {
        int currentPosWord1 = -1;
        int currentPosWord2 = -1;

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                currentPosWord1 = i;

                int distance = currentPosWord1 - currentPosWord2;

                if (currentPosWord2 >= 0 && (distance < minDistance)) {
                    minDistance = distance;
                }
            } else if (words[i].equals(word2)) {
                currentPosWord2 = i;

                int distance = currentPosWord2 - currentPosWord1;

                if (currentPosWord1 >= 0 && (distance < minDistance)) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }
}
