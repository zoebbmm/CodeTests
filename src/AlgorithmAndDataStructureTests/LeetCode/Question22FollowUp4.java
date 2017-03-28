package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weizhou on 10/26/16.
 */
public class Question22FollowUp4 {
    public static void main(String[] agrs) {
//        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
//
//        System.out.println(findMaximumXOR(nums));

//        int[] nums1 = new int[]{14, 11, 7, 2};
//        System.out.println(findMaximumXOR(nums1));

        int[] nums2 = new int[]{5, 25};
        System.out.println(findMaximumXOR(nums2));

    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 8; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
