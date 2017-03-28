package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/20/16.
 */
public class Question17 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};

        System.out.println(findMedianSortedArrays(a, 2, b, 2));

        int[] c = {1, 2};
        int[] d = {3};

        System.out.println(findMedianSortedArrays(c, 2, d, 1));

    }

    /**
     * Time- O(log(m+n))
     * @param A
     * @param m
     * @param B
     * @param n
     * @return
     */
    public static double findMedianSortedArrays(int A[], int m, int B[], int n) {
        /* A[0, 1, 2, ..., n-1, n] */
        /* A[0, 1, 2, ..., m-1, m] */
        int k = (m + n + 1) / 2;
        double v = (double) findKSmallest(A, 0, m - 1, B, 0, n - 1, k);

        if ((m + n) % 2 == 0) {
            int k2 = k + 1;
            double v2 = (double) findKSmallest(A, 0, m - 1, B, 0, n - 1, k2);
            v = (v + v2) / 2;
        }

        return v;
    }

    public static int findKSmallest(int[] a, int aStart, int aEnd, int[]b, int bStart, int bEnd, int k) {
        if (aStart > aEnd) {
            return b[bStart + k - 1];
        }

        if (bStart > bEnd) {
            return a[aStart + k - 1];
        }

        int aMid = (aStart + aEnd) / 2;

        int bMid = (bStart + bEnd) / 2;

        int halfLength = (aMid - aStart) + (bMid - bStart) + 1;

        if (a[aMid] > b[bMid]) {
            if (k > halfLength) {
                return findKSmallest(a, aStart, aEnd, b, bMid + 1, bEnd, k- (bMid - bStart + 1));
            } else {
                return findKSmallest(a, aStart, aMid - 1, b, bStart, bEnd, k);
            }
        } else {
            if (k > halfLength) {
                return findKSmallest(a, aMid + 1, aEnd, b, bStart, bEnd, k - (aMid - aStart + 1));
            } else {
                return findKSmallest(a, aStart, aEnd, b, bStart, bMid - 1, k);
            }
        }
    }
}
