package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question20 {
    public Node swapNodesInPairs(Node head) {
        if (head != null && head.next != null) {
            Node tmp1 = head.next.next;
            Node tmp2 = head.next;

            head.next.next = head;
            head.next = swapNodesInPairs(tmp1);
            return tmp2;
        } else {
            return head;
        }
    }
}
