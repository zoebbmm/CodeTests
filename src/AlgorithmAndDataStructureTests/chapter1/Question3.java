package AlgorithmAndDataStructureTests.chapter1;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question3 {
    public static void main(String[] args) {
        System.out.println(isPermutation("god", "dgod"));

    }

    public static Boolean isPermutation(String s, String t) {
        Boolean isPermutation = true;

        int[] asscii = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int currentS = s.charAt(i);
            asscii[currentS]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int currentT = t.charAt(j);

            if(asscii[currentT] <= 0) {
                return false;
            } else {
                asscii[currentT]--;
            }
        }

        return true;
    }
}
