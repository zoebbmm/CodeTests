package AlgorithmAndDataStructureTests.chapter2;

import java.util.Hashtable;

/**
 * Created by weizhou on 6/26/16.
 */
public class Question1 {
    public static void main(String[] args) {

    }

    //Using an extra data structure - HashTable
    //O(n)
    public static void removeDuplicate(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode current = head;

        Hashtable<Integer, Boolean> hashtable = new Hashtable<>();

        while (current != null) {
            if(hashtable.containsKey(current.data)) {
                previous.next = current.next;
            } else {
                hashtable.put(current.data, true);
                previous = current;
            }

            current = current.next;
        }
    }

    //Without using extra data structures
    public static void removeDuplicateRunner(LinkedListNode head) {
        LinkedListNode current = head;

        while(current != null) {
            LinkedListNode runner = current;

            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
