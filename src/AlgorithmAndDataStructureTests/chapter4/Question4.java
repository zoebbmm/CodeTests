package AlgorithmAndDataStructureTests.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question4 {
    public ArrayList<LinkedList<Node>> createLinkedListsNodes(Node root) {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();

        createLinkedlists(root, lists, 0);

        return lists;
    }

    // Time - O(log^n)
    // Space - O(n)
    private void createLinkedlists(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if (root == null) return;

        LinkedList<Node> nodeList = null;

        if (lists.size() == level) {
            nodeList = new LinkedList<>();

            lists.add(nodeList);
        } else {
            nodeList = lists.get(level);
        }

        nodeList.add(root);

        createLinkedlists(root.left, lists, level + 1);
        createLinkedlists(root.right, lists, level + 1);
    }
}
