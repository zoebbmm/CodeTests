package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/23/16.
 */
public class Question172FollowUp3 {
    /**
     * Since it goes a circle, either clockwise or anti-clockwise works;)
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }

        int sum =0, iteration = 0, len = A.length;

        for(int i=0; i<len; i++){
            sum += A[i];
            iteration += (A[i] * i);
        }

        int max = iteration;
        for(int j=1; j<len; j++){
            // for next iteration lets remove one entry value of each entry and the prev 0 * k
            iteration = iteration - sum + A[j-1]*len;
            max = Math.max(max, iteration);
        }

        return max;
    }

    public int maxRotateFunctionBlah(int[] A) {
        int n = A.length;
        int sum = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            current += i * A[i];
        }
        int result = current;
        for (int i = n - 1; i > 0; i--) {
            current += sum - n * A[i];
            result = Math.max(result, current);
        }
        return result;
    }
}
