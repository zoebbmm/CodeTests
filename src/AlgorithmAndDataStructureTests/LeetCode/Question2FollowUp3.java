package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 12/6/16.
 */
public class Question2FollowUp3 {
    public static void main(String[] agrs) {
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));
        System.out.println(getMaxRepetitions("acb", 4, "abab", 2));
        System.out.println(getMaxRepetitions("acb", 4, "cbcb", 2));


    }
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] reps = new int[102];
        int[] rests = new int[102];
        int posRest=0, repTime=0;
        int i=0, k=0;
        if(n1 <= 0) return 0;
        while(k==i) {
            i++;
            for(int j=0; j<s1.length(); j++) {
                if(s2.charAt(posRest) == s1.charAt(j)) {
                    posRest++;
                    if(posRest == s2.length()) {
                        repTime++;
                        posRest=0;
                    }
                }
            }
            if(i >= n1)
                return repTime / n2;

            // search in previous results
            // find a previous result that also ends up with the posResult-th character of s2
            // and the previous result is obtained when we had scanned s1 for k times.
            // Herefore, we found a repeat pattern of length s2.size()
            // That is: cover s1 (i-k) times can also cover (s2[posRest .... end], s2[0 ... posRest-1]) for integer times
            for(k=0; k<i; k++){
                if(posRest == rests[k])
                    break;
            }
            reps[i] = repTime; // we have covered s2 for rep times after we scan s1 for i times
            rests[i] = posRest; // we reach the posRest-th character in s2 after we scan s1 for i times
        }
        int interval = i-k;
        int repeatCount = (n1-k) / interval;
        int repeatTimes = repeatCount * (reps[i]-reps[k]);
        int remainTimes = reps[(n1-k) % interval + k];
        return (repeatTimes + remainTimes) / n2;
    }
}
