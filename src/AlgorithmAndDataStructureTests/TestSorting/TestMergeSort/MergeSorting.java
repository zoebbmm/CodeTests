package AlgorithmAndDataStructureTests.TestSorting.TestMergeSort;

/**
 * Created by weizhou on 6/16/16.
 */
public class MergeSorting {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        mergesort(list);

        for (int i : list) {
            System.out.println(i);
        }
    }

    // O(nlog^n)
    public static void mergesort(int[] ints) {
        if (ints.length > 1) {
            int[] firstHalfList = new int[ints.length/2];
            System.arraycopy(ints, 0, firstHalfList, 0, ints.length/2);
            mergesort(firstHalfList);

            int[] secondHalfList = new int[ints.length - ints.length/2];
            System.arraycopy(ints, ints.length/2, secondHalfList, 0, ints.length - (ints.length/2));
            mergesort(secondHalfList);

            int[] list = mergeArrays(firstHalfList, secondHalfList);
            System.arraycopy(list, 0, ints, 0, list.length);
        }
    }

    private static int[] mergeArrays(int[] list1, int[] list2) {
        int[] result = new int[list1.length + list2.length];

        int currentIndex1 = 0;
        int currentIndex2 = 0;
        int currentIndex3 = 0;

        while(currentIndex1 < list1.length && (currentIndex2 < list2.length)) {
            if (list1[currentIndex1] > list2[currentIndex2]) {
                result[currentIndex3] = list2[currentIndex2];
                currentIndex2++;
                currentIndex3++;
            } else{
                result[currentIndex3] = list1[currentIndex1];
                currentIndex1++;
                currentIndex3++;
            }
        }

        while(currentIndex1 < list1.length) {
            result[currentIndex3++] = list1[currentIndex1++];
        }

        while(currentIndex2 < list2.length) {
            result[currentIndex3++] = list2[currentIndex2++];
        }

        return result;
    }


}
