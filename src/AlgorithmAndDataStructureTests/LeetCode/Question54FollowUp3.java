package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54FollowUp3 {
    public static void main(String[] agrs) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ",");
            }

            System.out.println("********");
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }
}
