package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/15/16.
 */
public class Question145FollowUp4 {
    public static void main(String[] agrs) {
        int[] num1 = new int[]{1, 7, 11};

        int[] num2 = new int[]{1, 2, 4, 6};

        List<int[]> result = kSmallestPairs(num1, num2, 6);

        for(int[] arr : result) {
            for (int i : arr) {
                System.out.print(i);
            }

            System.out.println("**********");
        }
    }
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();

        k = Math.min(k, nums1.length*nums2.length);

        if(k==0)
            return result;

        int[] idx = new int[nums1.length];

        while(k>0){
            int min = Integer.MAX_VALUE;
            int t=0;
            for(int i=0; i<nums1.length; i++){
                if(idx[i]<nums2.length && nums1[i]+nums2[idx[i]]<min){
                    t=i;
                    min = nums1[i]+nums2[idx[i]];
                }
            }

            int[] arr = {nums1[t], nums2[idx[t]]};
            result.add(arr);

            idx[t]++;

            k--;
        }

        return result;
    }
}
