package AlgorithmAndDataStructureTests.chapter17;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question1 {
    public void swapNumbersInPlace(int a, int b) {
        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
