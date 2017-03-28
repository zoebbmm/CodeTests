package AlgorithmAndDataStructureTests.LeetCode;

import java.util.LinkedList;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question25FollowUp2 {
    public LinkedList<Integer> findCommonsIn3Arrays(int[] a, int[] b, int[] c) {
        int aIndex = 0;

        int bIndex = 0;

        int cIndex = 0;

        LinkedList<Integer> linkedList = new LinkedList<>();

        while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {
            if (a[aIndex] == b[bIndex] && a[aIndex] == c[cIndex]) {
                aIndex++;
                bIndex++;
                cIndex++;

                linkedList.add(a[aIndex]);
            } else {
                int min = Math.min(Math.min(a[aIndex], b[bIndex]), c[cIndex]);

                if (min == a[aIndex]) {
                    aIndex++;
                } else if (min == b[bIndex]) {
                    bIndex++;
                } else if (min == c[cIndex]) {
                    cIndex++;
                }
            }
        }

        return linkedList;
    }
}
