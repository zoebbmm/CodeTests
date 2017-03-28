package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question221 {
    public static void main(String[] agrs) {
//        List<Integer> result = lexicalOrder(13);
//
//        for (int i : result) {
//            System.out.println(i);
//        }

        List<Integer> result1 = lexicalOrderSolution2(600);

        for (int i : result1) {
            System.out.println(i);
        }

    }

    /**
     * Solution1
     *
     * @param n
     * @return
     */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res);
        }
        return res;
    }

    public static void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }

    /**
     * Solution2
     *
     * @param n
     * @return
     */
    public static List<Integer> lexicalOrderSolution2(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
