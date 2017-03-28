package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question3 {
    public int countTrailingZeros(int num) {
        int count = 0;

        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }

        return count;
    }

    private int factorsOf5(int num) {
        int count = 0;

        while (num % 5 == 0) {
            count ++;
            num = num/5;
        }

        return count;
    }
}
