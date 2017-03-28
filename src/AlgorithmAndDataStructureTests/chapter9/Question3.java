package AlgorithmAndDataStructureTests.chapter9;

/**
 * Created by weizhou on 7/8/16.
 */
public class Question3 {
    public int findMagicIndex(int[] arr) {
        return findMagicIndexHelper(arr, 0, arr.length - 1);
    }

    private int findMagicIndexHelper(int[] arr, int startIndex, int endIndex) {

        if (startIndex < 0 || endIndex >= arr.length || startIndex > endIndex) return -1;

        int midIndex = (startIndex + endIndex) / 2;

        if (arr[midIndex] == midIndex) {
            return midIndex;
        }

        int leftEndIndex = Math.min(midIndex, arr[midIndex]);

        int magicIndexAtLeft = findMagicIndexHelper(arr, startIndex, leftEndIndex);

        if (magicIndexAtLeft >= 0) {
            return magicIndexAtLeft;
        }

        int rightStartIndex = Math.max(midIndex, arr[midIndex]);

        int magicIndextAtRight = findMagicIndexHelper(arr, rightStartIndex, endIndex);

        return magicIndextAtRight;
    }
}
