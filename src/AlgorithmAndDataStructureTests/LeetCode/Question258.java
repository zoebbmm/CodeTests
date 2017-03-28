package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 12/6/16.
 */
public class Question258 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{2, -1, 1, 2, 2};

        int[] nums1 = new int[]{-1, 2};
        int[] nums2 = new int[]{2, 0, 2, 1, 3};

        System.out.println(circularArrayLoop2(nums));
        System.out.println(circularArrayLoop2(nums1));
        System.out.println(circularArrayLoop2(nums2));



    }
    public static boolean circularArrayLoop2(int[] nums) {
        if(nums==null||nums.length==0) return false;
        for(int a:nums){
            if(a==0) return false;
        }
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(checkCycle(nums,i)) return true;
        }
        return false;
    }
    public static boolean checkCycle(int[] nums, int start){
        int len=nums.length;
        int slow=((start+nums[start])%len+len)%len;
        int fast=((slow+nums[slow])%len+len)%len;
        while(slow!=fast){
            slow=((slow+nums[slow])%len+len)%len;
            fast=((fast+nums[fast])%len+len)%len;
            fast=((fast+nums[fast])%len+len)%len;
        }
        if(slow==((slow+nums[slow])%len+len)%len) return false;//one element loop
        boolean forward_backward=nums[slow]>0;//forward or backword
        int ptr=((slow+nums[slow])%len+len)%len;
        while(ptr!=slow){
            if(nums[ptr]>0!=forward_backward) return false;
            ptr=((ptr+nums[ptr])%len+len)%len;
        }
        return true;
    }
}
