package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question124FollowUp1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if(m.data > p.data && m.data < q.data){
            return m;
        }else if(m.data>p.data && m.data > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }else if(m.data<p.data && m.data < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
