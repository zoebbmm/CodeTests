package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question123FollowUp3 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, root);
        return result;
    }

    // traverse the tree bottom-up recursively
    private int helper(List<List<Integer>> list, TreeNode root){
        if(root==null)
            return -1;

        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int curr = Math.max(left, right)+1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if(list.size()<=curr){
            list.add(new ArrayList<Integer>());
        }

        list.get(curr).add(root.data);

        return curr;
    }
}
