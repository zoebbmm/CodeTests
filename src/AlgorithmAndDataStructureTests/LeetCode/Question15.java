package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question15 {
    public Node addTwoNumbers(Node l1, Node l2) {
        // check if the linked list is null
        if (l1 == null && l2 == null) return null;

        int carry = 0;

        Node p1 = l1;
        Node p2 = l2;
        Node p3 = new Node(0);
        Node head = p3;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.data;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.data;
                p2 = p2.next;
            }

            int d3 = carry % 10;
            carry /= 10;

            head.next = new Node(d3);
            head = head.next;
        }

        if (carry == 1) {
            head.next = new Node(1);
            head = head.next;
        }

        return p3.next;
    }
}
