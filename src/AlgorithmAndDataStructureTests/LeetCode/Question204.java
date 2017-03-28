package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question204 {
    public int guessNumber(int n) {
        int low=1;
        int high=n;

        while(low <= high){
            int mid = low+((high-low)/2);
            int result = guess(mid);
            if(result==0){
                return mid;
            }else if(result==1){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }

    private int guess(int mid) {
        int result = 0;

        /**
         * Predefined API guess()
         */

        return result;
    }
}
