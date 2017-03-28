package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/20/16.
 */
public class Question62 {
    public Node reverseListmn(Node head, int m, int n) {
        if (head == null || m == n) return null;

        Node dummy = new Node(0);
        dummy.next = head;

        Node start = dummy;
        Node prev = head;
        Node current = head.next;
        Node next = null;

        int count = 1;

        while (count <= n) {
            if (count >= m && count < n) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } else if (count == n) {
                start.next.next = current;
                start.next = prev;
            } else {
                start = prev;
                prev = current;
                current = current.next;
            }

            count++;
        }

        return dummy.next;
    }
}
