package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/20/16.
 */
public class Question16 {
    public int findKSmallest(int[] a, int aStart, int aEnd, int[]b, int bStart, int bEnd, int k) {
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
