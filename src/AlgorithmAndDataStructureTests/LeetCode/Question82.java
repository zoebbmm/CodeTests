package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question82 {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1 || k == 0) {
            return head;
        }

        int count = 1;

        Node runner = head;

        while (count < k && runner.next != null) {
            runner = runner.next;
            count++;
        }

        if (count != k) return head;

        Node prev = reverseKGroup(runner.next, k);

        Node current = head;

        while (current != runner) {
            Node next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }

        current.next = prev;

        return current;
    }
}
