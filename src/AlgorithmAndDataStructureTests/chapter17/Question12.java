package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question12 {
    /**
     *   If the array is nor sorted yet, sort it first!
     */
    public void findPairsEqualingToASpecifiedValue(int[] arr, int sum) {
        int first = 0;

        int last = arr.length - 1;

        while(first < last) {
            int actualSum = arr[first] + arr[last];
            if (actualSum == sum) {
                System.out.println(arr[first] + " : " + arr[last]);

                first++;
                last--;
            } else if (actualSum < sum) {
                first++;
            } else {
                last--;
            }
        }
    }
}
