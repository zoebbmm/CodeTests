package AlgorithmAndDataStructureTests.chapter1;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question1 {
    public static void main(String[] args) {
        System.out.println(isUniqueString("aad"));
    }

    public static Boolean isUniqueString(String str) {
        Boolean isUnique = true;

        Boolean[] booleanList = new Boolean[256];
        for (int i = 0; i < booleanList.length; i++) {
            booleanList[i] = false;
        }

        char[] chars = str.toCharArray();

        for(char c : chars) {
            int i = c;

            if(booleanList[i]) {
                return false;
            }

            booleanList[i] = true;
        }

        return isUnique;
    }
}
