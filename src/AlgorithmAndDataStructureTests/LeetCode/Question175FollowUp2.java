package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by weizhou on 8/6/16.
 */
public class Question175FollowUp2 {
    public static void main(String[] agrs) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortesDistance(words, "makes", "makes"));
    }

    public static int shortesDistance(String[] words, String w1, String w2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }

        ArrayList<Integer> l1 = map.get(w1);
        ArrayList<Integer> l2 = map.get(w2);

        int result = Integer.MAX_VALUE;
        for(int i1: l1){
            for(int i2: l2){
                int dist = Math.abs(i1-i2);
                if (dist != 0) {
                    result = Math.min(dist, result);
                }
            }
        }
        return result;
    }
}
