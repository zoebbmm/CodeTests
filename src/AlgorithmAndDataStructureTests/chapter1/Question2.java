package AlgorithmAndDataStructureTests.chapter1;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question2 {
    public static void main(String[] args) {

        String reversedStr = reverseString("Wei is well");

        System.out.println(reversedStr);

        StringBuffer stringBuffer = new StringBuffer();

        int start = 0;
        int end = 0;

        while(end < reversedStr.length()) {
            if (reversedStr.charAt(end) == ' ') {
                String reversedSubstring = reverseString(reversedStr.substring(start, end));
                stringBuffer.append(reversedSubstring + " ");
                start = end + 1;
            }

            end++;
        }

        if (reversedStr.charAt(end - 1) != ' ') {
            String reversedSubstring = reverseString(reversedStr.substring(start, end));
            stringBuffer.append(reversedSubstring);
        }

        System.out.println(stringBuffer.toString());

    }

    public static String reverseString(String str) {
        if (str == null) return str;

        int length = str.length() - 1;

        if(length == 0) return str;
        if(length == 1) return String.valueOf(str.charAt(1)) + String.valueOf(str.charAt(0));
        if(length == 2) return String.valueOf(str.charAt(2)) + String.valueOf(str.charAt(1)) + String.valueOf(str.charAt(0));

        return String.valueOf(str.charAt(length)) + reverseString(str.substring(1, length)) + String.valueOf(str.charAt(0));
    }


}
