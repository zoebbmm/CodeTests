package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/10/16.
 */
public class Question158FollowUp1 {
    public static void main(String[] args) {
//        Node n1 = new Node(2);
//        Node n2 = new Node(3);
//        Node n3 = new Node(4);
//
//        Node n4 = new Node(3);
//        Node n5 = new Node(4);
//        Node n6 = new Node(5);

        Node n1 = new Node(1);
        Node n2 = new Node(7);
        Node n3 = new Node(4);

        Node n4 = new Node(9);
        Node n5 = new Node(5);
        Node n6 = new Node(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = mergeSortList(n1);

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
    // merge sort
    public static Node mergeSortList(Node head) {

        if (head == null || head.next == null)
            return head;

        // count total number of elements
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        // break up to two list
        int middle = count / 2;

        Node l = head, r = null;
        Node p2 = head;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            Node next = p2.next;

            if (countHalf == middle) {
                p2.next = null;
                r = next;
                break;
            }
            p2 = next;
        }

        // now we have two parts l and r, recursively sort them
        Node h1 = mergeSortList(l);
        Node h2 = mergeSortList(r);

        // merge together
        Node merged = merge(h1, h2);

        return merged;
    }

    public static Node merge(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.data<l2.data){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
