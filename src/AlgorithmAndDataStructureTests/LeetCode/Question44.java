package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 12/6/16.
 */
public class Question44 {
    public static void main(String[] agrs) {
        String[] sentence = new String[]{"abc", "de", "f"};

        System.out.println(wordsTyping(sentence, 4, 6));
    }
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }
}
