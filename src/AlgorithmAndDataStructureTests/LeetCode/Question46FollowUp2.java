package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question46FollowUp2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }

        if(p.data==q.data){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
}
