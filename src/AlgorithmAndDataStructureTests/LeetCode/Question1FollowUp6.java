package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 11/22/16.
 */
public class Question1FollowUp6 {
    public static void main(String[] agrs) {
        int[] nums = new int[]{-1, 3, 2, 0};

        System.out.println(find132pattern(nums));

        int[] nums1 = new int[]{1, 2, 3, 4};

        System.out.println(find132pattern(nums1));

        int[] nums2 = new int[]{3, 1, 4, 2};

        System.out.println(find132pattern(nums2));
    }
    static class Pair{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public static boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }

            }
        }
        return false;
    }
}
