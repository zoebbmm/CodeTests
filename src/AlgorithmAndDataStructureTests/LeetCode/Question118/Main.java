package AlgorithmAndDataStructureTests.LeetCode.Question118;

/**
 * Created by weizhou on 10/31/16.
 */
public class Main {
    public static void main(String[] agrs) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);

        MinStack minStack = new MinStack();

        while (head != null) {
            minStack.push(head.data);
            head = head.next;
        }

        System.out.println(minStack.getMin());


    }
}
