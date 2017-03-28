package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question86FollowUp4 {
    public int superPow(int a, int[] b) {
        int result=1;

        for(int i=0; i<b.length; i++){
            result = helper(result, 10)*helper(a, b[i])%1337; // result^10
        }

        return result;
    }

    public int helper(int x, int n){
        if(n==0)
            return 1;
        if(n==1)
            return x%1337;

        return helper(x%1337, n/2)*helper(x%1337,n-n/2)%1337;
    }
}
