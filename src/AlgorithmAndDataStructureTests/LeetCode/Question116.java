package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 8/21/16.
 */
public class Question116 {
    public static void main(String[] args) {
        int[] ratings = new int[]{5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1};

        System.out.println(candy(ratings));
        System.out.println(candyConstantSpace(ratings));

    }

    /**
     * Time - O(n)  Space - O(n)
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candy[i];
        }

        return sum;
    }

    /**
     * Time - O(n) Space - O(1)
     * @param ratings
     * @return
     */
    public static int candyConstantSpace(int[] ratings) {
        int pre = 1, countDown = 0, total = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;   // progression part
                    if (countDown >= pre) { // check if pre is tall enough
                        total += countDown - pre + 1;
                    }
                    pre = 1;    // when ascending and there is countDown, prev should be 1
                    countDown = 0;
                }
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;   // when equals to previous one, set to 1. Else set to prev + 1
                total += pre;
            }
            else {
                countDown++;
            }
        }
        if (countDown > 0) {    // check if there is countDown in the end
            total += countDown * (countDown + 1) / 2;
            if (countDown >= pre) {
                total += countDown - pre + 1;
            }
        }
        return total;
    }
}
