package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by weizhou on 8/8/16.
 */
public class Question151FollowUp1 {
    /**
     * O(n + k)
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();

        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);

        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }

        return result;
    }

    private void getPredecessor(TreeNode root, double target, Stack<Integer> precedessor) {
        if (root == null) {
            return;
        }

        getPredecessor(root.left, target, precedessor);

        if (root.data > target) {
            return;
        }

        precedessor.push(root.data);

        getPredecessor(root.right, target, precedessor);
    }

    private void getSuccessor(TreeNode root, double target, Stack<Integer> successor) {
        if (root == null) {
            return;
        }

        getSuccessor(root.right, target, successor);

        if (root.data <= target) {
            return;
        }

        successor.push(root.data);

        getSuccessor(root.left, target, successor);
    }

    /**
     * O(k + logN)
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValuesOptimizer(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().data == pred.peek().data) {
            getNextPredecessor(pred);
        }
        while(k-- > 0) {
            if(succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if(pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double)succ.peek().data - target);
                double pred_diff = Math.abs((double)pred.peek().data - target);
                if(succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while(root != null) {
            if(root.data == target) {
                succ.push(root);
                break;
            } else if(root.data > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while(root != null){
            if(root.data == target){
                pred.push(root);
                break;
            } else if(root.data < target){
                pred.push(root);
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int ret = curr.data;
        curr = curr.right;
        while(curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return ret;
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int ret = curr.data;
        curr = curr.left;
        while(curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return ret;
    }
}
