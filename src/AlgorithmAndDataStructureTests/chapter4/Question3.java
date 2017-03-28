package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question3 {
    public Node createBinarySearchTreeWithMinimumHeight(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end)/2;

        Node root = new Node(arr[mid]);

        root.left = createBinarySearchTreeWithMinimumHeight(arr, start, mid -1);
        root.right = createBinarySearchTreeWithMinimumHeight(arr, mid + 1, end);

        return root;
    }
}
