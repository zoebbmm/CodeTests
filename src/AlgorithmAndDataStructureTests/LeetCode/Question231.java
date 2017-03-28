package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/30/16.
 */
public class Question231 {
    public static void main(String[] agrs) {
        System.out.println(bulbSwitch(4));
        System.out.println(bulbSwitchSolutionOptimized(8));

    }
    public static int bulbSwitchSolutionOptimized(int n) {
        return (int)Math.sqrt(n);
    }

    public static int bulbSwitch(int n) {
        int count=0;
        for(int i=1; i<=n; i++){
            int numSwitch = helper(i);
            if(numSwitch%2 ==1)
                count++;
        }

        return count;
    }

    public static int helper(int n){
        int count=0;
        for(int i=1; i<=n; i++){
            if(n%i==0)
                count++;
        }
        return count;
    }
}
