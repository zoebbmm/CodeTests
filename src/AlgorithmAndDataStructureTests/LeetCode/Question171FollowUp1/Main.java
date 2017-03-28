package AlgorithmAndDataStructureTests.LeetCode.Question171FollowUp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/24/16.
 */
public class Main {
    public static void main(String[] agrs) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);

        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());

        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());

        System.out.println(peekingIterator.peek());





    }
}
