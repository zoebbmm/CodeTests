package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question130FollowUp2 {
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
