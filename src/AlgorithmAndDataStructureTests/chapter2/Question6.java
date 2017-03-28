package AlgorithmAndDataStructureTests.chapter2;

/**
 * Created by weizhou on 6/30/16.
 */
public class Question6 {
    public static void main(String[] agrs) {

    }

    public LinkedListNode findLoopHead(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while(fastPointer != null && (fastPointer.next!= null)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                break;
            }
        }

        if (fastPointer == null) {
            return null;
        }

        slowPointer = head;

        while(slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return fastPointer;
    }
}
