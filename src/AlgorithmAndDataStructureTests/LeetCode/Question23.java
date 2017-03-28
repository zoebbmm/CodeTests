package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question23 {
    public String integerToRoman(int num) {
        if (num < 1 || num > 3999) return "-1";

        int[] romanIntegers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanStrings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";

        for (int i = romanIntegers.length - 1; i>= 0; i--) {
            while (num >= romanIntegers[i]) {
                roman += romanStrings[i];

                num -= romanIntegers[i];
            }
        }

        return roman;
    }
}
