package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question9FollowUp1 {
    public List<Node> findIntersectedNodes(Node head1, Node head2) {
        List<Node> list = new ArrayList<>();

        if (head1 == null || head2 == null) {
            return list;
        }

        Node cursor1 = head1;
        Node cursor2 = head2;

        while (cursor1 != null && cursor2 != null) {
            if (cursor1.data == cursor2.data) {
                list.add(cursor1);
                cursor1 = cursor1.next;
                cursor2 = cursor2.next;
            } else if (cursor1.data < cursor2.data) {
                cursor1 = cursor1.next;
            } else {
                cursor2 = cursor2.next;
            }
        }

        return list;
    }
}
