package AlgorithmAndDataStructureTests.chapter2;

import java.util.Stack;

/**
 * Created by weizhou on 6/30/16.
 */
public class Question7 {
    public static void main(String[] agrs) {

    }

    public Boolean isPalidrome(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fasterPointer = head;

        Stack stack = new Stack();

        while (fasterPointer != null && (fasterPointer.next != null)) {
            stack.add(slowPointer);
            slowPointer = slowPointer.next;
            fasterPointer = fasterPointer.next.next;
        }

        if (fasterPointer!= null) {
            slowPointer = slowPointer.next;
        }

        while (slowPointer != null) {
            LinkedListNode top = (LinkedListNode) stack.pop();

            if(top != slowPointer) {
                return false;
            }

            slowPointer = slowPointer.next;
        }

        return true;
    }
}
