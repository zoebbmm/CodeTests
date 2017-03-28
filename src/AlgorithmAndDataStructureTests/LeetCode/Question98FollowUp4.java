package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/15/16.
 */
public class Question98FollowUp4 {

    public static void main(String[] agrs) {
        int[] nums = new int[]{4, 3, 1, 2, 5};

        System.out.println(thirdMaxNumber(nums));
    }

    public static int thirdMaxNumber(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        for (int num : nums) {
            if (a < num) {
                c = b;
                b = a;
                a = num;
            } else if ( a > num && num > b) {
                c = b;
                b = num;
            } else if ( b > num && num > c) {
                c = num;
            }
        }

        if (c != Integer.MIN_VALUE) {
            return c;
        } else {
            return a;
        }
    }
}
