package AlgorithmAndDataStructureTests.chapter2;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question2 {
    public static void main(String[] args) {

    }

    public static LinkedListNode findKthToLastNode(int k, LinkedListNode head) {
        if (head == null) return null;

        if (k <= 0) return null;

        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for (int i = 0; i < k-1; i++) {
            p2 = p2.next;
        }

        if(p2 == null) return null;

        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
