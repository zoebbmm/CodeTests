package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/11/16.
 */
public class Question149FollowUp1 {
    public static void main(String[] agrs) {
        Node n1 = new Node(7);
        Node n2 = new Node(1);
        Node n3 = new Node(4);

        Node n4 = new Node(9);
        Node n5 = new Node(5);
        Node n6 = new Node(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = oddEvenList(n1);

        printList(n1);
    }

    public static void printList(Node x) {
        if(x != null){
            System.out.print(x.data + " ");
            while (x.next != null) {
                System.out.print(x.next.data + " ");
                x = x.next;
            }
            System.out.println();
        }

    }

    public static Node oddEvenList(Node head) {
        if(head == null)
            return head;

        Node result = head;
        Node p1 = head;
        Node p2 = head.next;
        Node connectNode = head.next;

        while(p1 != null && p2 != null){
            Node t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }
}
