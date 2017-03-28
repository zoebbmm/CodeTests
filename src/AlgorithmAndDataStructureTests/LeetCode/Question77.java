package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/22/16.
 */
public class Question77 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6};

        System.out.println(searchInsert(nums, 5));
//        System.out.println(searchInsert(nums, 2));
//        System.out.println(searchInsert(nums, 7));
//        System.out.println(searchInsert(nums, 0));

    }
    /**
     * Time - O(log^n)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(nums==null)
            return -1;
        if(target>nums[nums.length-1]){
            return nums.length;
        }

        int i=0;
        int j=nums.length;

        while(i<j){
            int m=(i+j)/2;
            if(target>nums[m]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return j;
    }
}
