package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/15/16.
 */
public class Question188 {
    public static void main(String[] agrs) {
        int[][] updates = new int[3][3];

        updates[0][0] = 1;
        updates[0][1] = 3;
        updates[0][2] = 2;
        updates[1][0] = 2;
        updates[1][1] = 4;
        updates[1][2] = 3;
        updates[2][0] = 0;
        updates[2][1] = 2;
        updates[2][2] = -2;

        int[] result = getModifiedArray(5, updates);

        for (int i : result) {
            System.out.println(i);
        }

    }
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0], end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;
            if (end < length - 1) {
                result[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
