package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question64 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(nums));
    }
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        if (height.length == 1) {
            return height[0];
        }

        Stack<Integer> stack = new Stack<Integer>();
        int[] copy = new int[height.length + 1];
        System.arraycopy(height, 0, copy, 0, height.length);

        int maxArea = 0;
        int i = 0;

        while (i < copy.length) {
            if (stack.isEmpty() || copy[i] > copy[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int localArea = copy[index] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, localArea);
            }
        }

        return maxArea;
    }
}
