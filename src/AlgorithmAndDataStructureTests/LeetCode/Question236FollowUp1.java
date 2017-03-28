package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question236FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
    }
    public static int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        int min = 0, max = citations.length - 1;
        while(min <= max){
            int mid = (min + max) / 2;
            // 如果该点是有效的H指数，则最大H指数一定在右边
            if(citations[mid] < n - mid){
                min = mid + 1;
                // 否则最大H指数在左边
            } else {
                max = mid - 1;
            }
        }
        // n - min是min点的H指数
        return n - min;
    }
}
