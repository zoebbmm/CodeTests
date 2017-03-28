package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question91FollowUp2 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }

            sb.append(carry % 2);
            carry /= 2;
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
