package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question234FollowUp1 {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] arr = s.toCharArray();

        return canWinHelper(arr);
    }

    private boolean canWinHelper(char[] arr) {
        int i = 0;

        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';

                boolean win = !canWinHelper(arr);

                arr[i] = '+';
                arr[i + 1] = '+';

                if (win) {
                    return true;
                }
            }
        }

        return false;
    }
}
