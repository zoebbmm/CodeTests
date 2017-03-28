package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question9 {
    public static void main(String[] agrs) {
        Node l1 = new Node(10);
        l1.next = new Node(15);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(20);

        Node l2 = new Node(8);
        l2.next = new Node(4);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(10);

        List<Node> result = isIntersected(l1, l2);

        for (Node n : result) {
            System.out.println(n.data);
        }

    }
    public static List<Node> isIntersected(Node head1, Node head2) {

        List<Node> result = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != null) {
            set.add(t1.data);
            t1 = t1.next;
        }

        while (t2 != null) {
            if (set.contains(t2.data)) {
                result.add(t2);
            }

            t2 = t2.next;
        }

        return result;
    }
}
