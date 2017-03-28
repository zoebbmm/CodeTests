package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/24/16.
 */
public class Question209FollowUp2 {
    public boolean canMeasureWater(int x, int y, int z) {
        return x + y == z || (x + y > z ) && z % gcd(x,y) == 0;
    }

    private int gcd(int a,int b){
        return b==0? a: gcd(b,a%b);
    }
}
