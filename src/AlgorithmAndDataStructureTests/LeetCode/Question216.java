package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question216 {
    public static void main(String[] agrs) {
        System.out.println(convertToTitle(26));
    }
    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            n--;

            int val = n % 26;
            char title = (char) (val + 'A');
            sb.insert(0, title);

            n /= 26;
        }

        return sb.toString();
    }
}
