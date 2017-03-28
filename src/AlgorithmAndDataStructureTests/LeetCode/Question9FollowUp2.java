package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/11/16.
 */
public class Question9FollowUp2 {
    public static void main(String[] agrs) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node n11 = new Node(9);
        Node n12 = new Node(7);
        Node n13 = new Node(4);

        Node n14 = new Node(5);
        Node n15 = new Node(6);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        System.out.println(getIntersectionNode(n1, n11).data);
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        int len1 = 0;
        int len2 = 0;
        Node p1=headA, p2=headB;
        if (p1 == null || p2 == null)
            return null;

        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 !=null){
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1=headA;
        p2=headB;

        if(len1 > len2){
            diff = len1-len2;
            int i=0;
            while(i<diff){
                p1 = p1.next;
                i++;
            }
        }else{
            diff = len2-len1;
            int i=0;
            while(i<diff){
                p2 = p2.next;
                i++;
            }
        }

        while(p1 != null && p2 != null){
            if(p1.data == p2.data){
                return p1;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }

        }

        return null;
    }
}
