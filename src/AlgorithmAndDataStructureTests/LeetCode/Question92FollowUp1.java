package AlgorithmAndDataStructureTests.LeetCode;

import java.util.LinkedList;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question92FollowUp1 {
    /**
     * Recursive
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root!=null){
            helper(root);
        }

        return root;
    }

    public void helper(TreeNode p){

        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left!=null)
            helper(p.left);

        if(p.right!=null)
            helper(p.right);
    }

    /**
     * Iterrative
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeIterrative(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }

        return root;
    }
}
