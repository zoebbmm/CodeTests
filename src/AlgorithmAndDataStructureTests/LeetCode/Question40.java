package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;

/**
 * Created by weizhou on 8/2/16.
 */
public class Question40 {
    public ArrayList<ArrayList<Integer>> generatePascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0)
            return result;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }

        return result;
    }
}
