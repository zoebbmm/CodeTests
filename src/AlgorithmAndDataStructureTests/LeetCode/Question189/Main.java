package AlgorithmAndDataStructureTests.LeetCode.Question189;

import java.util.List;

/**
 * Created by weizhou on 8/16/16.
 */
public class Main {
    public static void main(String[] agrs) {
        int[] nums = new int[]{3, 2, 2, 6, 1};

        Solution solution = new Solution();

        List<Integer> result = solution.countSmaller(nums);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
