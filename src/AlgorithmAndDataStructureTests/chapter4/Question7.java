package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question7 {
    public Node commonAncestor(Node root, Node p, Node q) {
        if (!containNode(root, p) || !containNode(root, q)) {
            return null;
        }

        return findCommonAncestor(root, p, q);
    }


    private Boolean containNode(Node root, Node n) {
        if (root == null) return false;

        if (root == n) return true;

        return containNode(root.left, n) || containNode(root.right, n);
    }

    // Time - O(n)
    private Node findCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        Boolean is_p_at_left = containNode(root.left, p);
        Boolean is_q_at_left = containNode(root.right, q);

        if (is_p_at_left != is_q_at_left) return root;

        Node nextPassRoot = is_p_at_left ? root.left : root.right;

        return findCommonAncestor(nextPassRoot, p, q);
    }
}
