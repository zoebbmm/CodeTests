package AlgorithmAndDataStructureTests.LeetCode;

import java.util.*;

/**
 * Created by weizhou on 9/23/16.
 */
public class Question60FollowUp4 {
    public static void main(String[] agrs) {
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};

        System.out.println(frogJump(stones));

        int[] stones1 = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(frogJump(stones1));


    }
    public static boolean frogJump(int[] stones) {
//        // the most progressive arrange is [0, 1, 3, 6, 10, 15, 21, ...]
//// the right-most point is at most 0 + (1 + len - 1) * (len - 1) / 2
//        if(stones == null || stones.length == 0 || stones[1] != 1 ||
//                stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) return false;
//
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}
