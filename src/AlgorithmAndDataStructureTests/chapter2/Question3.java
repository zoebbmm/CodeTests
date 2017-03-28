package AlgorithmAndDataStructureTests.chapter2;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question3 {
    public static void main(String[] args) {

    }

    public static void deleteSpecificNode(LinkedListNode node) {
        if(node == null || node.next == null) return;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;

        return;
    }
}
