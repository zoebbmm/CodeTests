package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question236 {
    public static void main(String[] agrs) {
        int[] citations = {0, 5, 5, 6, 5, 5, 8};

        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        // Reverse the array
        int m = 0;
        int n = citations.length - 1;
        while (m < n) {
            swap(citations, m, n);
            m++;
            n--;
        }

        int len = citations.length;

        int i = 0;
        for (i = 0; i < len; i++) {
            if (i + 1 > citations[i]) {
                return i;
            }
        }

        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int hIndexSolution2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Step 1: Accmulate the number of citations for each bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n) {
                buckets[citations[i]]++;
            } else {
                buckets[n]++;
            }
        }

        // Step 2: iterate the citations from right to left.
        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += buckets[i];
            if (numPapers >= i) {
                return i;
            }
        }

        return 0;
    }
}
