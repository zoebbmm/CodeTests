package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question78 {
    public static void main(String[] agrs) {
        int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 7);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int[] arr= new int[2];
        arr[0]=-1;
        arr[1]=-1;

        binarySearch(nums, 0, nums.length-1, target, arr);

        return arr;
    }

    public static void binarySearch(int[] nums, int left, int right, int target, int[] arr){
        if(right<left)
            return;

        int mid = (right+left)/2;


        if(nums[mid]<target){
            binarySearch(nums, mid+1, right, target, arr);
        }else if(nums[mid]>target){
            binarySearch(nums, left, mid-1, target, arr);
        }else{
            arr[0]=mid;
            arr[1]=mid;

            //handle duplicates - left
            int t1 = mid;
            while(t1 >left && nums[t1]==nums[t1-1]){
                t1--;
                arr[0]=t1;
            }

            //handle duplicates - right
            int t2 = mid;
            while(t2 < right&& nums[t2]==nums[t2+1]){
                t2++;
                arr[1]=t2;
            }
            return;
        }
    }
}
