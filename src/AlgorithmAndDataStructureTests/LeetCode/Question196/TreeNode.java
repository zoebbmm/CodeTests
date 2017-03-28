package AlgorithmAndDataStructureTests.LeetCode.Question196;

/**
 * Created by weizhou on 8/20/16.
 */
public class TreeNode {
    int start;
    int end;
    int sum;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int left, int right, int sum){
        this.start=left;
        this.end=right;
        this.sum=sum;
    }
    public TreeNode(int left, int right){
        this.start=left;
        this.end=right;
        this.sum=0;
    }
}
