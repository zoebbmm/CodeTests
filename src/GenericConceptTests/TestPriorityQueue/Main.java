package GenericConceptTests.TestPriorityQueue;

import java.util.*;

/**
 * Created by weizhou on 7/30/16.
 */
public class Main {
    public static void main(String[] agrs) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        priorityQueue.offer(2);
        priorityQueue.offer(6);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(7);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek());
            priorityQueue.poll();
        }

        System.out.println("****************");

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        queue.offer(6);
        queue.offer(1);
        queue.offer(3);
        queue.offer(8);
        queue.offer(7);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }
}
