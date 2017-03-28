package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question131 {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }
}
