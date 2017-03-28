package AlgorithmAndDataStructureTests.TestGreatestCommonDevisor;

/**
 * Created by weizhou on 5/31/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findGCD(9, 3));
        System.out.println(improvedFindGCD(9, 6));
    }

    //O(n)
    private static int findGCD(int m, int n) {
        int gcd = 1;

        if (m % n == 0) {
            return n;
        }

        for (int k = n/2; k >= 1; k++) {
            if (m%k == 0 && (n%k == 0)) {
                gcd = k;
            }
        }

        return gcd;
    }

    //O(log^n)
    private static int improvedFindGCD(int m, int n) {
        int gcd = 1;

        if (m % n == 0) {
            return n;
        } else {
            gcd = improvedFindGCD(n, m%n);
        }
        return gcd;
    }
}
