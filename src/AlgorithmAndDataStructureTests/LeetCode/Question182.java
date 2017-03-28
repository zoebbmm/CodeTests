package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/11/16.
 */
public class Question182 {
    public static void main(String[] agrs) {
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        Node n3 = new Node(9);

        n1.next = n2;
        n2.next = n3;

        n1 = plusOne(n1);

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

    public static Node plusOne(Node head) {
        if( DFS(head) == 0){
            return head;
        }else{
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
    }

    public static int DFS(Node head){
        if(head == null) return 1;

        int carry = DFS(head.next);

        if(carry == 0) return 0;

        int val = head.data + 1;
        head.data = val%10;
        return val/10;
    }
}
