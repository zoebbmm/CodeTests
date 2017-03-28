package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 10/31/16.
 */
public class Question131FollowUp5 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> result = findDisappearedNumbers(nums);

        for (int i : result) {
            System.out.println(i);
        }
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
