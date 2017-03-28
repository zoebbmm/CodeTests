package AlgorithmAndDataStructureTests.chapter18;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question4 {
    public int find2s (int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            count += find2sForEachNumber(i);
        }

        return count;
    }

    private int find2sForEachNumber(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 10 == 2) {
                count++;
            }

            n = n/10;
        }

        return count;
    }
}
