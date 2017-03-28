package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54FollowUp7 {
    public static void main(String[] agrs) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};

        System.out.println(fourSumCount(A, B, C, D));
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumCounter = getSumCounters(A,B);
        int fourSumCounter = 0;
        for (int c : C) {
            for (int d: D) {

                if (sumCounter.containsKey(c + d)) {
                    fourSumCounter += sumCounter.get(c + d);
                }
//                fourSumCounter += sumCounter.getOrDefault(c+d, 0);
            }
        }
        return fourSumCounter;
    }

    private static HashMap<Integer, Integer> getSumCounters(int [] A, int [] B) {
        HashMap<Integer, Integer> sumCounter = new HashMap<>();
        for (int a : A) {
            for (int b: B) {
                int sum = -a-b;
                sumCounter.put(sum, sumCounter.getOrDefault(sum, 0) + 1);
            }
        }
        return sumCounter;
    }
}
