package AlgorithmAndDataStructureTests.TestFibonaci;

/**
 * Created by weizhou on 5/26/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findFibImproved(5));
        System.out.println(findFibImproved(7));

    }

    // O(n)
    private static long findFibImproved(long index) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        long f3 = 0;

        if (index == 0) {
            return f0;
        } else if (index == 1) {
            return f1;
        } else if (index == 2) {
            return f2;
        }

        for (int i = 3; i <= index; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    // O(2^n)
    private static long findFibBasic(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return findFibBasic(index -1) + findFibBasic(index - 2);
        }
    }
}
