package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = {2, 7, 11, 15};

        int[] result = twoSum(nums, 9);

        for(int i : result) {
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                i++;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return null;
    }
}
