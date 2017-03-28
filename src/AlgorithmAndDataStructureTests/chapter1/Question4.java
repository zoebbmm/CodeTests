package AlgorithmAndDataStructureTests.chapter1;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question4 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("I am well."));
    }

    public static String replaceSpace(String str) {
        if (str == null) return str;

        char[] chars = str.toCharArray();

        int count = 0;
        int newLength = 0;

        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }

        newLength = str.length() + count * 2;
        char[] newChars = new char[newLength];

        for (int i = str.length()-1; i>=0; i--) {
            if(str.charAt(i) == ' ') {
                newChars[newLength-1] = '0';
                newChars[newLength-2] = '2';
                newChars[newLength-3] = '%';
                newLength = newLength - 3;
            } else {
                newChars[newLength-1] = str.charAt(i);
                newLength = newLength - 1;
            }
        }

        String result = new String(newChars);
        return result;
    }
}
