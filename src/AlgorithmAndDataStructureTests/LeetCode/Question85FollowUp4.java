package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question85FollowUp4 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{0, 1, 3, 50, 75};

        List<String> result = findMissingRanges(nums, 0, 99);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            outputToResult(lower, upper, result);
            return result;
        }

        // leading missing range
        if (nums[0] - lower > 1) {
            outputToResult(lower, nums[0] - 1, result);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                outputToResult(nums[i - 1] + 1, nums[i] - 1, result);
            }
        }

        // trailing missage ranges
        if (upper - nums[nums.length - 1] > 1) {
            outputToResult(nums[nums.length - 1] + 1, upper, result);
        }

        return result;
    }

    private static void outputToResult(int start, int end, List<String> result) {
        StringBuffer sb = new StringBuffer();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start + "->" + end);
        }

        result.add(sb.toString());
    }
}
