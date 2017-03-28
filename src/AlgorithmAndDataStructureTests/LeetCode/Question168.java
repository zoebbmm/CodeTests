package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/10/16.
 */
public class Question168 {
    public void reorderList(Node head) {
        if (head  == null || head.next == null || head.next.next == null) return;

        // STEP 1: Find the middle point of the linked list, use fast-slow pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHead = slow.next;
        slow.next = null; //truncate the first half

        // STEP 2: Reverse the second list
        Node prev = secondHead;
        Node curr = secondHead.next;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // setup the new head
        secondHead.next = null;
        secondHead = prev;


        // STEP 3: Merge the two lists together
        Node p1 = head;
        Node p2 = secondHead;

        while (p2 != null) {
            Node temp1 = p1.next;
            Node temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
        if (p1 != null) p1.next = null; //tail pointer
    }
}
