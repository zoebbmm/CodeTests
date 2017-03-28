package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/6/16.
 */
public class Question143 {
    public static void main(String[] agrs) {
        String[] words = {"ab", "abcw", "baz", "foo", "xtfn", "abcdef"};

        System.out.println(maxProduct(words));

    }

    public static int maxProduct(String[] words) {
        if(words==null || words.length==0)
            return 0;

        int[] arr = new int[words.length];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);

                int tmp = 1 << (c - 'a');

                arr[i] |= tmp;

                System.out.println(arr[i]);
            }
        }

        int result = 0;

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if((arr[i] & arr[j]) == 0){
                    result = Math.max(result, words[i].length()*words[j].length());
                }
            }
        }

        return result;
    }
}
