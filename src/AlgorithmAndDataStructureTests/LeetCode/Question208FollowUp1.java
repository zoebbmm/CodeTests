package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/23/16.
 */
public class Question208FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(isSubsequence("cb", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;

        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }

            j++;

            if(i==s.length())
                return true;
        }

        return false;
    }
}
