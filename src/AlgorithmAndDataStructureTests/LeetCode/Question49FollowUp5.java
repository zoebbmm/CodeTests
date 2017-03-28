package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/11/16.
 */
public class Question49FollowUp5 {
    public Node removeElements(Node head, int val) {
        Node helper = new Node(0);
        helper.next = head;
        Node p = helper;

        while(p.next != null){
            if(p.next.data == val){
                Node next = p.next;
                p.next = next.next;
            }else{
                p = p.next;
            }
        }

        return helper.next;
    }
}
