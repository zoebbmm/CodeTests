package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashSet;

/**
 * Created by weizhou on 10/31/16.
 */
public class Question251 {
    public static void main(String[] agrs) {
        String[] bank = new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"};

        System.out.println(minMutationH("AAAAACCC", "AACCCCCC", bank));

        String[] bank1 = new String[] {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"};

        System.out.println(minMutationH("AAAAAAAA", "CCCCCCCC", bank1));

        String[] bank2 = new String[] {"AACCGGTA"};

        System.out.println(minMutationH("AACCGGTT", "AACCGGTA", bank2));

        String[] bank3 = new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println(minMutationH("AACCGGTT", "AAACGGTA", bank3));
    }

    static HashSet<String> tempBank = new HashSet<String>();
    public static int minMutationH(String start, String end, String[] bank) {
        // build a hash set for faster lookups
        for(String s:bank){
            tempBank.add(s);
        }
        return minMutationR(start,end);
    }

    public static int minMutationR(String start, String end){
        if(start.equals(end)){ // base case
            return 0;
        }
        int min = -1;
        for(int i=0; i<start.length() && i<end.length(); i++){
            // find a single possible mutaion
            if(start.charAt(i) != end.charAt(i)){
                // change that 1 character
                StringBuilder test = new StringBuilder(start);
                test.setCharAt(i, end.charAt(i));
                String newStart = test.toString();
                // test if it's in the bank
                if(tempBank.contains(newStart)){
                    // recursivly call on new mutated srting
                    int res = minMutationR(newStart,end);
                    // only update min if result was 0 or positive
                    if(res != -1){
                        // min is the smaller of min and 1+res (if min is not -1)
                        min = (min==-1) ? (1 + res) : Math.min(min, 1 + res);
                    }
                }
            }
        }
        return min;
    }
}
