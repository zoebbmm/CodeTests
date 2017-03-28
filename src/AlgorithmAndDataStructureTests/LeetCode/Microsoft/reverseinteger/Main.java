package AlgorithmAndDataStructureTests.LeetCode.Microsoft.reverseinteger;

/**
 * Created by weizhou on 11/6/16.
 */
public class Main {
    public static void main(String[] agrs) {

        System.out.println(Integer.MAX_VALUE);

        PrintVertially(1023);
        PrintVertially(-123);

    }

    public static void PrintVertially(int i) {
        if (i == 0) {
            System.out.println(i);
        }


        boolean isNeg = false;

        if (i < 0) {
            isNeg = true;

            i = -i;
        }

        int div = 1;

        while (i / div >= 10) {
            div *= 10;
        }


        if (isNeg) {
            System.out.println("-");
        }
        while( i > 0) {
            System.out.println( i / div);

            i = i % div;

            div /= 10;
        }
    }
}
