package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question91FollowUp6 {
    public int getSum(int a, int b) {

        while(b!=0){
            int c = a&b;
            a=a^b;
            b=c<<1;
        }

        return a;
    }
}
