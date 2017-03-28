package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question114 {
    /**
     * Recursive
     */
    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root !=null){
            helper(root);
        }

        return result;
    }

    public void helper(TreeNode p){
        if(p.left!=null)
            helper(p.left);

        result.add(p.data);

        if(p.right!=null)
            helper(p.right);
    }

    /**
     * Iterrative
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterrative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }else{
                result.add(top.data);
                stack.pop();
                if(top.right!=null){
                    stack.push(top.right);
                }
            }
        }

        return result;
    }
}
