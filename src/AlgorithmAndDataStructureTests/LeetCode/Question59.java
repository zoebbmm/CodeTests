package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question59 {
    public Node rightMoveK(Node head, int k) {
        if (head == null || k == 0) return null;

        Node p1 = head;
        Node p2 = head;

        while (k > 0) {
            p2 = p2.next;
            k--;

            if (p2 == null) {
                p2 = head;
            }
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        Node newHead = p1.next;
        p2.next = head;
        p1.next = null;

        return newHead;

    }
}
