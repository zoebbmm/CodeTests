package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;

/**
 * Created by weizhou on 8/2/16.
 */
public class Question98 {
    public static void main(String[] agrs) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLISApproach1(nums));
    }
    /**
     * Time - O(n^2)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLISApproach1(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        max[0] = 1;

        int result = 1;

        for(int i=1; i< nums.length; i++){
            max[i] = 1;

            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);
                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

    /**
     * Time- O(nlog^n)
     *
     * @param nums
     * @return
     */
    public int lengthOfLISApproach2(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num: nums){
            if(list.size()==0){
                list.add(num);
            }else if(num>list.get(list.size()-1)){
                list.add(num);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }

}
