package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question8FollowUp3 {
    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        ArrayList<ArrayList<Integer>> result = createLinkedListsNodes(root);
//
//        for(ArrayList list : result) {
//            for (Object node : list) {
//                System.out.reverseinteger((Integer) node + ", ");
//
//            }
//
//            System.out.println("******");
//        }

        LinkedList<List<Integer>> result1 = (LinkedList<List<Integer>>) levelOrderBottomUp(root);

        for(List list : result1) {
            for (Object node : list) {
                System.out.print((Integer) node + ", ");

            }

            System.out.println("******");
        }
    }

    /**
     * Solution1
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> createLinkedListsNodes(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        createLinkedlists(root, lists, 0);


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = lists.size() - 1; i >= 0; i--) {
            result.add(lists.get(i));
        }

        return result;
    }

    // Time - O(n)
    // Space - O(logN)
    private static void createLinkedlists(TreeNode root, ArrayList<ArrayList<Integer>> lists, int level) {
        if (root == null) return;

        ArrayList<Integer> nodeList = null;

        if (lists.size() == level) {
            nodeList = new ArrayList<>();

            lists.add(nodeList);
        } else {
            nodeList = lists.get(level);
        }

        nodeList.add(root.data);

        createLinkedlists(root.left, lists, level + 1);
        createLinkedlists(root.right, lists, level + 1);
    }

    /**
     * Solution2
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottomUp(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        addLevel(list, 0, root);
        return list;
    }

    private static void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
        if (node == null) return;
        if (list.size() == level) list.addFirst(new LinkedList<Integer>());
        list.get(list.size()-1-level).add(node.data);
        addLevel(list, level+1, node.left);
        addLevel(list, level+1, node.right);
    }
}
