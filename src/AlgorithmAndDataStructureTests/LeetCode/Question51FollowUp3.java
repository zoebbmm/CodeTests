package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question51FollowUp3 {
    public static void main(String[] agrs) {
        int[] nums = {1, 2, 3};

        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;

        int[] dp = new int[target+1];

        dp[0]=1;

        for(int i=0; i<=target; i++){
            for(int num: nums){
                if(i+num<=target){
                    dp[i+num]+=dp[i];
                }
            }
        }

        return dp[target];
    }
}
