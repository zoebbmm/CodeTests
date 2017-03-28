package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question60FollowUp5 {
    public static void main(String[] agrs) {
        System.out.println(canIWin(10, 11));
    }
    public static boolean canIWin(int n, int total) {
        if (total <= 1) {
            return true;
        }
        if ((1 + n) * n / 2 < total) {
            return false;
        }
        Boolean[] map = new Boolean[1 << n];
        return canWin(total, n, 0, map);
    }

    public static boolean canWin(int remains, int n, int status, Boolean[] map) {
        if (map[status] != null) {
            return map[status];
        }
        for (int i = n; i >= 1; i--) {
            int bit = 1 << (i - 1);
            if ((status & bit) == 0) {
                if (i >= remains) {
                    map[status] = true;
                    return true;
                }

                status ^= bit;
                boolean opWin = canWin(remains - i, n, status, map);
                status ^= bit;
                if (!opWin) {
                    map[status] = true;
                    return true;
                }
            }
        }
        map[status] = false;
        return false;
    }

    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWinSolution2(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;

        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }

    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)){
            for(int i=1; i<used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    if(!helper(desiredTotal-i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    // transfer boolean[] to an Integer
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
