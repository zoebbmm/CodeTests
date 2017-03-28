package AlgorithmAndDataStructureTests.LeetCode.Question15FollowUp1;

/**
 * Created by weizhou on 10/30/16.
 */
public class DoublyLinkedListNode {
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    int val;

    public DoublyLinkedListNode(int v, DoublyLinkedListNode p, DoublyLinkedListNode n) {
        this.val = v;
        this.prev = p;
        this.next = n;
    }
}
