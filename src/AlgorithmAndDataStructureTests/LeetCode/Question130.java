package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/4/16.
 */
public class Question130 {
    public static void main(String[] agrs) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
