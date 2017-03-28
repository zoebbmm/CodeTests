package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/31/16.
 */
public class Question237 {
    public static void main(String[] ahrs) {
        List<String> result = generateAbbreviationsBetter("word");

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> generateAbbreviationsBetter(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, new StringBuilder(), 0);

        return ret;
    }

    private static void backtrack(List<String> ret, String word, int pos, StringBuilder curr, int count){
        int len = curr.length();

        if(pos==word.length()){
            if(count > 0) curr.append(count);
            ret.add(curr.toString());
        } else{
            backtrack(ret, word, pos + 1, curr, count + 1);
            backtrack(ret, word, pos+1, curr.append((count>0 ? count : "")).append( word.charAt(pos)), 0);
        }
        curr.setLength(len);
    }
}
