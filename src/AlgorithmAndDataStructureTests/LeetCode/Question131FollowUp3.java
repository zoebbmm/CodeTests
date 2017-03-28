package AlgorithmAndDataStructureTests.LeetCode;

import java.util.*;

/**
 * Created by weizhou on 8/16/16.
 */
public class Question131FollowUp3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};

        List<Integer> result = topKFrequent(nums, 2);

        for (int i : result) {
            System.out.println(i);
        }

    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // step 1: count the freq of each word
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, freq + 1);
            } else {
                map.put(num, 1);
            }
        }

        // step 2: use a min-heap to get the top k frequencies.
        PriorityQueue<Pair> pq = new PriorityQueue<>(new MyPQComparator());
        int count = 0;
        for (int word : map.keySet()) {
            int freq = map.get(word);
            Pair pair = new Pair(freq, word);
            if (count < k) {
                pq.offer(pair);
                count++;
            } else if (pair.freq > pq.peek().freq) {
                pq.poll();
                pq.offer(pair);
            }
        }

        // step 3: output the result
        for (Pair pair : pq) {
            result.add(pair.word);
        }

        return result;
    }

    private static class MyPQComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return a.freq - b.freq;
        }
    }
}

class Pair {
    int word;
    int freq;

    Pair(int freq, int word) {
        this.word = word;
        this.freq = freq;
    }
}
