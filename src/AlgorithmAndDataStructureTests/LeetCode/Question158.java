package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/20/16.
 */
public class Question158 {
    public static Node insertionSortList(Node head) {

        if (head == null || head.next == null)
            return head;

        Node newHead = new Node(head.data);
        Node pointer = head.next;

        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list

            Node innerPointer = newHead;
            Node next = pointer.next;

            if (pointer.data <= newHead.data) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {

                    if (pointer.data > innerPointer.data && pointer.data <= innerPointer.next.data) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.data > innerPointer.data) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally
            pointer = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
//        Node n1 = new Node(2);
//        Node n2 = new Node(3);
//        Node n3 = new Node(4);
//
//        Node n4 = new Node(3);
//        Node n5 = new Node(4);
//        Node n6 = new Node(5);

        Node n1 = new Node(3);
        Node n0 = new Node(1);
        Node n2 = new Node(7);
        Node n3 = new Node(4);

        Node n4 = new Node(9);
        Node n5 = new Node(5);
        Node n6 = new Node(2);

        n1.next = n0;
        n0.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

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

    public static Node insertionSortListsss(Node head) {
        if (head==null ||head.next==null){
            return head;
        }

        Node preHead=new Node (-1);

        preHead.next=head;
        Node run=head;


        while (run!=null && run.next!=null){

            if (run.data > run.next.data){
                // find node which is not in order
                Node smallNode=run.next;

                Node pre=preHead;

                // find position for smallNode
                while (pre.next.data<smallNode.data){
                    pre=pre.next;
                }


                Node temp=pre.next;
                pre.next=smallNode;

                run.next=smallNode.next;
                smallNode.next=temp;

            }
            else{
                // node is in order
                run=run.next;

            }

        }

        return preHead.next;

    }
}
