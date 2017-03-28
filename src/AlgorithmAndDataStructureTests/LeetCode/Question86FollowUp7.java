package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question86FollowUp7 {
    public static void main(String[] agrs) {
        System.out.println(isPowerOfFour(8));
    }
    public boolean isPowerOfFourSolution1(int num) {
        while(num>0){
            if(num==1){
                return true;
            }

            if(num%4!=0){
                return false;
            }else{
                num=num/4;
            }
        }

        return false;
    }

    public boolean isPowerOfFourSolution2(int num) {
        if(num==0) return false;

        int pow = (int) (Math.log(num) / Math.log(4));
        if(num==Math.pow(4, pow)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isPowerOfFour(int num) {

        if (num <= 0) {
            return false;
        }

        if ((num & (num - 1)) != 0) {
            return false;
        }

        // check if the '1' bit is on the even position
        int pos = 0;
        int mask = 1;
        for (int i = 0; i < 31; i++) {
            if ((num & mask) == 1) {
                break;
            }
            num = (num >> 1);
            pos++;
        }

        return pos % 2 == 0;
    }
}
