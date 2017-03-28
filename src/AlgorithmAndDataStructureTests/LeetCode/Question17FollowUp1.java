package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by weizhou on 7/30/16.
 */
public class Question17FollowUp1 {
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap;//lower half
        PriorityQueue<Integer> minHeap;//higher half

        public MedianFinder(){
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            minHeap = new PriorityQueue<Integer>();
        }

        // Adds a number into the data structure.
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if(maxHeap.size()==minHeap.size()){
                return (double)(maxHeap.peek()+(minHeap.peek()))/2;
            }else{
                return maxHeap.peek();
            }
        }
    }

    public static void main(String[] agrs) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(6);
        medianFinder.addNum(8);
        medianFinder.addNum(7);
        medianFinder.addNum(12);
        medianFinder.addNum(9);
        medianFinder.addNum(13);
        medianFinder.addNum(10);
        medianFinder.addNum(11);
        medianFinder.addNum(14);
        medianFinder.addNum(15);

        System.out.println(medianFinder.findMedian());

    }
}
