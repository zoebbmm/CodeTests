package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question49FollowUp1 {
    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummyNode = new Node(Integer.MIN_VALUE);
        dummyNode.next = head;

        Node prev = dummyNode;
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node next = curr.next;
            if (curr.data == next.data) {
                while (curr.next != null && curr.data == next.data) {
                    curr = curr.next;
                    next = next.next;
                }

                prev.next = next;
                curr = next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }
}
