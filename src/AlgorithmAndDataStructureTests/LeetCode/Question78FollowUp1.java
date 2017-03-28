package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question78FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{-2, 5, -1};

        int[] nums1 = new int[]{-2, 2};


        System.out.println(countRangeSumblah(nums, -2, 2));
    }

    /**
     * Time - O(nlog^n)
     *
     */
    public static int countRangeSumblah(int[] nums, int lower, int upper) {
        int length = nums.length;
        if(length <= 0)
            return 0;
        long[] counts = new long[nums.length];
        counts[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            counts[i] = counts[i-1]+nums[i];
        }

        return countNum(nums,0,length-1, lower, upper, counts);
    }
    private static int countNum(int[] nums,int left,int right, int lower, int upper, long[] counts){
        if(left == right){
            if(nums[left] >=lower && nums[right] <= upper)
                return 1;
            return 0;
        }
        int mid = (left+right)/2;
        int total = 0;
        for(int i = left;i<=mid;i++){
            for(int j = mid+1;j<=right;j++){
                long tmpNum = counts[j] - counts[i] + nums[i];
                if(tmpNum >= lower && tmpNum <= upper)
                    ++total;
            }
        }
        //采用二分法
        return total + countNum(nums,left,mid, lower, upper, counts) + countNum(nums,mid+1,right, lower, upper, counts);
    }
}
