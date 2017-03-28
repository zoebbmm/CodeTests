package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/31/16.
 */
public class Question100FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(arrangeCoins(5));

        System.out.println(arrangeCoins(8));

        System.out.println(arrangeCoins(1));

        System.out.println(arrangeCoins(3));

        System.out.println(arrangeCoinsBS(5));

        System.out.println(arrangeCoinsBS(8));

        System.out.println(arrangeCoinsBS(1));

        System.out.println(arrangeCoinsBS(3));


    }
    public static int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8 * (long)n) - 1) / 2);
    }

    public static int arrangeCoinsBS(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = (l + r)/2;

            if (mid * (mid + 1)/2 > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
