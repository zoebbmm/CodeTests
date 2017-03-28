package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question6 {
    public Node nextNode(Node n) {
        if (n == null) return null;

        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            Node parent = n.parent;

            Node current = n;

            while((parent != null) && (parent.left != current)) {
                current = parent;

                parent = parent.parent;
            }

            return parent;
        }
    }

    public Node leftMostChild(Node n) {
        if (n == null) return null;

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}
