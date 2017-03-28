package AlgorithmAndDataStructureTests.chapter17.Question13;

/**
 * Created by weizhou on 7/11/16.
 */
public class Question13 {
    public NodePair convertBinarySearchTreeToDoublyLinkedList(BiNode root) {
        if (root == null) return null;

        NodePair prevNode = convertBinarySearchTreeToDoublyLinkedList(root.node1);
        NodePair nextNode = convertBinarySearchTreeToDoublyLinkedList(root.node2);

        if (prevNode != null) {
            combine(prevNode.tail, root);
        }

        if (nextNode != null) {
            combine(root, nextNode.head);
        }

        return new NodePair(prevNode == null ? root : prevNode.head,
                nextNode == null ? root : nextNode.tail);
    }

    private void combine(BiNode n1, BiNode n2) {
        n1.node2 = n2;
        n2.node1 = n1;
    }
}
