package AlgorithmAndDataStructureTests.TestBinarySearch;

/**
 * Created by weizhou on 6/25/16.
 */
public class BuildBinarySearchTree {
    private TreeNode root = null;
    private int size = 0;

    public BuildBinarySearchTree(int[] objects) {
        for(int i : objects) {
            insert(i);
        }
    }

    //Insert
    public Boolean insert(int element) {
        Boolean result = false;

        if (root == null) {
            root = createNode(element);
            return true;
        } else {
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if (element < current.element) {
                    parent = current;
                    current = current.left;
                } else if(element > current.element) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if (element < parent.element) {
                parent.left = createNode(element);
            } else if (element > parent.element) {
                parent.right = createNode(element);
            }

            size ++;
            return true;
        }
    }

    // Create a Node
    public TreeNode createNode(int element) {
        return new TreeNode(element);
    }

    // Size
    public int size() {
        return size;
    }

    //Inorder
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.element);
        inorder(root.right);
    }

    //Postorder
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element);
    }

    //Preorder
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }
}
