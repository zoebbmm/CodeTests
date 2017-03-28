package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/4/16.
 */
public class Question130FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(reverseWords("the sky is blue".toCharArray()));
    }

    public static String reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);

        return new String(s);
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
