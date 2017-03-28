package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question28 {
    public Node mergeTwoLists(Node l1, Node l2) {
        Node ans = new Node(0);
        Node prev = ans;
        while(l1 != null && l2 != null){
            if(l1.data > l2.data){
                prev.next = l2;
                l2 = l2.next;
            } else{
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if(l2 == null){
            prev.next = l1;
        } else {
            prev.next = l2;
        }
        return ans.next;
    }

    public Node mergeTwoSortedLists(Node n1, Node n2) {
        if (n1 == null && n2 == null) return null;

        if (n1 == null) return n2;

        if (n2 == null) return n1;

        if (n1.data <= n2.data) {
            n1.next = mergeTwoSortedLists(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoSortedLists(n1, n2.next);
            return n2;
        }
    }
}
