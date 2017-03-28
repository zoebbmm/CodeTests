package AlgorithmAndDataStructureTests.chapter1;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question5 {
    public static void main(String[] args) {
        System.out.println(compressString("aavvvccccdaa"));
    }

    public static String compressString(String str) {
        if (str == null) return str;

        int length = countCompressedString(str);
        if(length >= str.length()) {
            return str;
        }

        StringBuffer stringBuffer = new StringBuffer();

        int count = 1;
        char first = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                count++;
            } else {
                stringBuffer.append(first);
                stringBuffer.append(count);
                first = str.charAt(i);
                count = 1;
            }
        }

        stringBuffer.append(first);
        stringBuffer.append(count);

        return stringBuffer.toString();
    }

    private static int countCompressedString(String str) {
        char first = str.charAt(0);
        int count = 1;
        int size = 0;

        for(int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                count++;
            } else {
                first = str.charAt(i);
                size += String.valueOf(count).length() + 1;
                count = 1;
            }
        }

        size += String.valueOf(count).length() + 1;
        return size;
    }
}
