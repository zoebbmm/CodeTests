package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54 {
    public static void main(String[] agrs) {
        int[] nums = {2, 11, 7, 15};

        int[] result = twoSum(nums, 9);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }
}
