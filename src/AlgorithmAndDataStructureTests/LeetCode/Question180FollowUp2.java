package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/9/16.
 */
public class Question180FollowUp2 {

    public static void main(String[] agrs) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(DFSserialize(root));

        System.out.println(DFSdeserialize(DFSserialize(root)).data);
    }

    public static String DFSserialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        sdfs(str, root);
        return str.substring(0, str.length() - 1);
    }

    private static void sdfs(StringBuilder str, TreeNode root) {
        if(root == null) str.append("#,");
        else {
            str.append(root.data + ",");
            sdfs(str, root.left);
            sdfs(str, root.right);
        }
    }

    public static TreeNode DFSdeserialize(String data) {
        String[] nodes = ("#," + data).split(",");
        TreeNode dummy = new TreeNode(0);
        ddfs(dummy, 0, nodes);
        return dummy.right;
    }

    private static int ddfs(TreeNode root, int index, String[] nodes) {
        if(root == null) return index;
        else {
            String left = nodes[index++];
            if(!left.equals("#")) {
                root.left = new TreeNode(Integer.parseInt(left));
                index = ddfs(root.left, index, nodes);
            }
            String right = nodes[index++];
            if(!right.equals("#")) {
                root.right = new TreeNode(Integer.parseInt(right));
                index = ddfs(root.right, index, nodes);
            }
        }
        return index;
    }
}
