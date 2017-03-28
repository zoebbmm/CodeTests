package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/19/16.
 */
public class Question49 {
    public void removeDupWithHashMap(Node n) {
        HashMap<Node, Boolean> map = new HashMap<>();

        if (n == null) return;

        Node prev = null;

        while(n != null) {
            if (map.containsKey(n)) {
                prev.next = n.next;
            } else {
                map.put(n, true);
                prev = n;
            }

            n = n.next;
        }
    }

    public void removeDupInPlace(Node n) {
        Node current = n;
        Node runner = null;

        if (n == null) return;

        while (current != null) {
            runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
