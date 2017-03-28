package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 8/29/16.
 */
public class Question91FollowUp7 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{1, 2, 4, 3, 8};

        List<Integer> result = largestDivisibleSubsetDP(nums);

        for (int i : result) {
            System.out.println(i);
        }

        int[] nums1 = new int[]{1, 2, 4, 12};

        List<Integer> result1 = largestDivisibleSubset(nums1);

        for (int i : result1) {
            System.out.println(i);
        }


    }

    static List<Integer> answer;
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();

        Arrays.sort(nums);

        int[] max = new int[1];
        List<Integer> result = new ArrayList<Integer>();
        helper(nums, 0, result, max);
        return answer;
    }

    public static void helper(int[] nums, int start, List<Integer> result, int[] max){
        if(result.size()>max[0]){
            max[0]=result.size();
            answer=new ArrayList<Integer>(result);
        }

        if(start==nums.length)
            return;

        for(int i=start; i<nums.length; i++){
            if(result.size()==0){
                result.add(nums[i]);
                helper(nums, i+1, result, max);
                result.remove(result.size()-1);

            }else{

                int top = result.get(result.size()-1);
                if(nums[i]%top==0){
                    result.add(nums[i]);
                    helper(nums, i+1, result, max);
                    result.remove(result.size()-1);
                }
            }
        }
    }

    /**
     * Solution2
     */
    public static List<Integer> largestDivisibleSubsetDP(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
