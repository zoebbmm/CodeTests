package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question5 {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0)
            return "";
        if (nRows == 1) return s;

        StringBuilder sb = new StringBuilder(); //non-thread safe
        int size = 2 * nRows - 2; // number of elements for each zigzag

        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));

                if (i != 0 && i != nRows - 1 && (j + size - 2 * i) < s.length()) {
                    sb.append(s.charAt(j + size - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
