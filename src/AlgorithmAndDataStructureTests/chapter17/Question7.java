package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question7 {
    String[] bigUnit = {"", "Thousand", "Million"};

    String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};

    public String convertNumberToEnglishString(int num) {
        if (num == 0) return "Zero";

        if (num < 0 ) return "Negative" + convertNumberToEnglishString(-1 * num);

        String str = "";

        int count = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                str = numToString100(num % 1000) + bigUnit[count] + str;
            }

            num = num/1000;
        }

        return str;
    }

    private String numToString100(int num) {
        String str = "";

        if (num >= 100) {
            str = digits[num/100 - 1] + "Hundred";

            num = num % 100;
        }

        if (num >= 11 && num <= 19) {
            return str + teens[num%10 - 1];
        }

        if (num == 10 || num == 20) {
            str += tens[num/10 - 1];
            num = num % 10;
        }

        if (num >= 1 && num <= 9) {
            str += digits[num - 1];
        }

        return str;
    }
}
