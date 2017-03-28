package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question24FollowUp1 {
    public static void main(String[] agrs) {
        int[] nums = {3, 30, 34, 5, 9};

        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftRight = s1+s2;
                String rightLeft = s2+s1;
                return rightLeft.compareTo(leftRight);

            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
        }

        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
