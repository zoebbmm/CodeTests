package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/11/16.
 */
public class Question135FollowUp2 {
    public boolean isPalindrome(Node head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        Node fast = head;
        Node slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        Node p1 = secondHead;
        Node p2 = p1.next;

        while(p1!=null && p2!=null){
            Node temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        Node p = (p2==null?p1:p2);
        Node q = head;
        while(p!=null){
            if(p.data != q.data)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
}
