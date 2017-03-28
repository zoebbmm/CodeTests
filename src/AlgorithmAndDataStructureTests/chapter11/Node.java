package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/10/16.
 */
public class Node {
    int data;
    int leftSize = 0;

    Node left;
    Node right;

    public Node(int d) {
        this.data = d;
    }

    public void insert(int d) {
        if (d <= data) {
            if (left == null) {
                left = new Node(d);
            } else {
                left.insert(d);
            }
            leftSize++;
        } else {
            if (right == null) {
                right = new Node(d);
            } else {
                right.insert(d);
            }
        }
    }

    public int getRankOfNumber(int targetNumber) {
        if (targetNumber == data) {
            return leftSize;
        } else if (targetNumber < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRankOfNumber(targetNumber);
            }
        } else {
            if (right == null) {
                return -1;
            } else {
                return leftSize + 1 + right.getRankOfNumber(targetNumber);
            }
        }
    }
}
