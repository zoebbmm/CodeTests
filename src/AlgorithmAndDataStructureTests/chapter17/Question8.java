package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question8 {
    public int findMaxSum(int[] arr) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
