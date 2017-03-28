package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question73 {
    public static void main(String[] agrs) {
        System.out.println(isNumber(" 10.23E1"));
    }

    public static boolean isNumber(String s) {
        int i = 0;
        int n = s.length();

        // step 1: skip leading white spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // step 2: Skip + or - sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean isNumeric = false;
        // step 3: skip the first segement of numeric characters
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }

        // step 4 and 5 skip the . character and the following numeric characters, if any
        if (i < n && s.charAt(i) == '.') {
            i++;
            isNumeric = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        // step 6 and 7 and 8, exponent character and following numeric characters
        if (isNumeric && i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        // step 9: Remove trailing white spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        return isNumeric && i == n;
    }
}
