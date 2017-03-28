package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question173FollowUp1 {
    public static void main(String[] agrs) {
        List<TreeNode> list = generateTreesUnderstand(3);

        for(TreeNode node : list) {
            System.out.println(node.data);
        }
    }

    public static List<TreeNode> generateTreesUnderstand(int n) {
        return generateTrees(1,n);
    }

    public static List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start>end){  trees.add(null); return trees;}

        for(int rootValue=start;rootValue<=end;rootValue++){
            List<TreeNode> leftSubTrees=generateTrees(start,rootValue-1);
            List<TreeNode> rightSubTrees=generateTrees(rootValue+1,end);

            for(TreeNode leftSubTree:leftSubTrees){
                for(TreeNode rightSubTree:rightSubTrees){
                    TreeNode root=new TreeNode(rootValue);
                    root.left=leftSubTree;
                    root.right=rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

}
