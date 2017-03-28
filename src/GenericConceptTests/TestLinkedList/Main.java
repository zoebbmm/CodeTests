package GenericConceptTests.TestLinkedList;

import java.util.LinkedList;

/**
 * Created by weizhou on 9/28/16.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.println(list.peek());


        LinkedList<Integer> list2 = new LinkedList<>();
        list2.offer(1);
        list2.offer(2);
        list2.offer(3);
        list2.offer(4);
        list2.offer(5);

        System.out.println(list2.peek());


    }
}
