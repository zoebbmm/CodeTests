package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 7/17/16.
 */
public class Question72FollowUp1 {

    public static void main(String[] agrs) {
        System.out.println(isOneEditDistance("abc", "adc"));
        System.out.println(isOneEditDistance("abc", "adcd"));
        System.out.println(isOneEditDistance("abc", "ac"));
        System.out.println(isOneEditDistance("ac", "adc"));

    }

    public static boolean isOneEditDistance(String s, String t) {
        //1. s < t
        //2. t > s
        //3. t = s and one character difference
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) return false;
        if(s.length() == t.length()) return sameLength(s, t);
        String longer = s.length() - t.length() > 0 ? s : t;
        String shorter = s.length() - t.length() < 0 ? s : t;
        int i = 0, j = 0, dif = 0;
        while(i < longer.length() && j < shorter.length()) {
            if(shorter.charAt(j) != longer.charAt(i)){
                i++;
                dif++;
            } else {
                i++;
                j++;
            }
        }
        if(dif > 1) return false;
        return true;
    }

    private static boolean sameLength(String s, String t) {
        char[] news = s.toCharArray();
        int dif = 0;
        for(int i = 0; i < s.length(); i++) {
            if(t.charAt(i) == news[i]) continue;
            dif++;
        }
        return dif == 1 ? true : false;
    }
}
