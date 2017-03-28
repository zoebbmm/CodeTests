package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/13/16.
 */
public class Question1 {
    public static void main(String[] agrs) {
        System.out.println(removeCharacters("ABCIDCA"));
    }

    public static String removeCharacters(String s) {
        char[] arr = s.toCharArray();

        int j = 0;

        int i = 0;

        while (i < s.length()) {
            if (arr[i] == 'A' || arr[i] == 'I') {
                i++;
            }else {
                arr[j] = arr[i];
                j++;
                i++;
            }
        }

        while (j < s.length()) {
            arr[j] = ' ';
            j++;
        }

        return new String(arr);
    }

}
