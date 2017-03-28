package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question8 {

    public int trackNumber(int[] arr, int targetNumber) {
        Node root = null;

        for (int i : arr) {
            trackAndRecordLeftSize(root, i);
        }

        int rank = root.getRankOfNumber(targetNumber);

        return rank;
    }

    private void trackAndRecordLeftSize(Node root, int num) {
        if (root == null) {
            root = new Node(num);
        } else {
            root.insert(num);
        }
    }
}
