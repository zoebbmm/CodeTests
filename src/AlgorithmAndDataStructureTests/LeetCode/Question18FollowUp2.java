package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question18FollowUp2 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<Integer> result = rightSideView(root);

        result.forEach(i -> System.out.println(i));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.data);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }

        return result;
    }
}
