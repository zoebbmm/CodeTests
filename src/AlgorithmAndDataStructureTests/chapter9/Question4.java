package AlgorithmAndDataStructureTests.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weizhou on 7/7/16.
 */
public class Question4 {

    public static void main(String[] agrs) {
        int[] num = {1, 2, 2};

        List<List<Integer>> subsets = subsetsWithDupIterrative(num);

        for (List<Integer> list : subsets) {
            for (int i : list) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    // Recursive approach
    // Time - O(2^n)
    public static List<List<Integer>> subsetsWithDupRecursive(int[] nums) {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        L.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        subsetsWithDup(nums,L,new ArrayList<Integer>(),0);
        return L;
    }

    private static void subsetsWithDup(int[] nums,List<List<Integer>> L,List<Integer> currentList,int start){
        if (start >= nums.length) return;

        int prevNum = Integer.MIN_VALUE;
        for (int i=start;i<nums.length;i++){
            if (prevNum != nums[i]){
                currentList.add(nums[i]);
                L.add(new ArrayList<Integer>(currentList));
                subsetsWithDup(nums,L,currentList,i+1);
                currentList.remove((int)currentList.size()-1);
            }
            prevNum = nums[i];
        }
    }

    // Iterate approach
    public static List<List<Integer>> subsetsWithDupIterrative(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }
}
