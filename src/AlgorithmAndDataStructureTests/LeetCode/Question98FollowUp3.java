package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/2/16.
 */
public class Question98FollowUp3 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(wiggleMaxLength(nums));

        int[] nums1 = new int[]{3, 3, 3, 2, 5};

        System.out.println(wiggleMaxLength(nums1));
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        if(nums.length<2){
            return nums.length;
        }

        int count=1;


        for(int i=1, j=0; i<nums.length; j=i, i++){
            if(nums[j]<nums[i]){
                count++;
                while(i<nums.length-1 && nums[i]<=nums[i+1]){
                    i++;
                }
            }else if(nums[j]>nums[i]){
                count++;
                while(i<nums.length-1 && nums[i]>=nums[i+1]){
                    i++;
                }
            }
        }

        return count;
    }
}
