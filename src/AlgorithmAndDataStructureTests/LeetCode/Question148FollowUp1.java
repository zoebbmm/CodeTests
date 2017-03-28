package AlgorithmAndDataStructureTests.LeetCode;

import java.util.*;

/**
 * Created by weizhou on 8/15/16.
 */
public class Question148FollowUp1 {
    /**
     * NestedIntList 1:
     * Sort the two arrays and iterate over to find out the intersections.
     * So the overall time complexity is bounded by O(n logn), where n is the length of the longer array. The Main body of the loop is bounded by O(m + n).
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectSolution1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        // Convert list to array
        return result.stream().mapToInt(m->m).toArray();
    }

    /**
     * NestedIntList 2:
     * Use a HashMap to store the first array, then check each element of the second array and see if it is in the map.
     * Note that since we need to output all repeated elements, we also need to count the occurrence of each array element in the map, and consume it when we compare with the second array.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectSolution2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        // step1: Put elements in nums1 into the map
        for (int num : nums1) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, freq + 1);
            } else {
                map.put(num, 1);
            }
        }

        // step 2: iterate the nums2 and get the result
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }

        return result.stream().mapToInt(m->m).toArray();
    }

}
