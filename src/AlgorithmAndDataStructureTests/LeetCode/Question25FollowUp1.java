package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question25FollowUp1 {
    public static void main(String[] agrs) {
        int[] a = {1, 3, 5, 7, 8, 7, 9};

        int[] b = {3, 2, 5, 5, 7, 10};

        HashSet<Integer> list = findCommonsIn2Arrays(a, b);

        for(int i : list) {
            System.out.println(i);
        }
    }
    public static HashSet<Integer> findCommonsIn2Arrays(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        HashSet<Integer> result = new HashSet<>();

        for (int i : a) {
            set.add(i);
        }

        for (int j : b) {
            if (set.contains(j)) {
                result.add(j);
            }
        }

        return result;
    }
}
