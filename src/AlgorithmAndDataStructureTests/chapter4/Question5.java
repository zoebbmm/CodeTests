package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question5 {
    private static int lastNodeValue = Integer.MIN_VALUE;

    public Boolean isBinarySearchTree(Node root) {
        if (root == null) return true;

        if (!isBinarySearchTree(root.left)) return false;

        int currentNodeValue = root.value;

        if (currentNodeValue <= lastNodeValue) return false;

        lastNodeValue = currentNodeValue;

        if (!isBinarySearchTree(root.right)) return false;

        return true;
    }
}
