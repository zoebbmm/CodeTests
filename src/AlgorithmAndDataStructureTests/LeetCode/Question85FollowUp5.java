package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question85FollowUp5 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 6, 8};

        List<String> result = summaryRanges(nums);

        for(String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            String curr = nums[0] + "";
            result.add(curr);
            return result;
        }

        // General case
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                String curr = generateRange(nums, j, i - 1);
                result.add(curr);
                j = i;
            }
        }

        // Final case
        String curr = generateRange(nums, j, nums.length - 1);
        result.add(curr);

        return result;
    }

    private static String generateRange(int[] nums, int start, int end) {
        if (start > end) {
            return "";
        }

        if (start == end) {
            String curr = nums[start] + "";
            return curr;
        }

        String curr = nums[start] + "->" + nums[end];
        return curr;
    }
}
