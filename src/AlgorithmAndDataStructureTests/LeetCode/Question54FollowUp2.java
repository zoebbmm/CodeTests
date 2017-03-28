package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/31/16.
 */
public class Question54FollowUp2 {
    static class TwoSum {
        private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

        public void add(int number) {
            if (elements.containsKey(number)) {
                elements.put(number, elements.get(number) + 1);
            } else {
                elements.put(number, 1);
            }
        }

        public boolean find(int value) {
            for (Integer i : elements.keySet()) {
                int target = value - i;
                if (elements.containsKey(target)) {
                    if (i == target && elements.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] agrs) {
        TwoSum twoSum = new TwoSum();

        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        System.out.println(twoSum.find(4));

    }
}
