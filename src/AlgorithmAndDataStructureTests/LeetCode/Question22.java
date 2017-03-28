package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question22 {
    public static void main(String[] agrs) {
        System.out.println(reverseBits(28));
    }
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (n != 0) {
                result = (result << 1) | (n & 1);
                n = (n >> 1);
            } else {
                break;
            }
        }

        return result;
    }
}
