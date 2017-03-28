package AlgorithmAndDataStructureTests.LeetCode;

import java.util.LinkedList;

/**
 * Created by weizhou on 8/21/16.
 */
public class Question164 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{4, 2, 5, 3, 7, 9};

        int[] result = maxSlidingWindow(nums, 3);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }

            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }

        return result;
    }

}
