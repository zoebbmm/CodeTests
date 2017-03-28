package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question7 {
    public Node combine2LinkedListsAlternatively(Node list1, Node list2) {
        Node head = null;

        if (list1 != null && list2 != null) {
            head = list1;
        } else if (list1 == null) {
            head = list2;
            return head;
        } else if (list2 == null) {
            head = list2;
            return head;
        }

        Node list1Next = null;
        Node list2Next = null;

        while (list1 != null && list2 != null) {
            if (list1.next == null && list2.next == null) {
                list1.next = list2;
                break;
            } else if (list1.next == null) {
                list1.next = list2;
                break;
            }

            list1Next = list1.next;
            list2Next = list2.next;
            list1.next = list2;
            list2.next = list1Next;
            list1 = list1Next;
            list2 = list2Next;
        }

        return head;
    }
}
