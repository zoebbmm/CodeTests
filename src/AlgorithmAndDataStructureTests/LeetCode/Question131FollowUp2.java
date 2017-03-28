package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question131FollowUp2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int xor = 0;

        // Step 1: calculate the xor for all numbers
        // So the result is the xor of the two single numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: find the first bit 1 from right
        int mask = 1;
        while ((mask & xor) == 0) {
            mask = mask << 1;
        }

        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }

        int[] result = new int[]{xor1, xor2};

        return result;
    }
}
