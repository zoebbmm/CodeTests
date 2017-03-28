package AlgorithmAndDataStructureTests.LeetCode.Microsoft.tupleCount;

/**
 * Created by weizhou on 11/28/16.
 */
public class Main {
    public static void main(String[] agrs) {
        Tuple tuple = bitcoUNT(123);

        System.out.println(tuple.x);
        System.out.println(tuple.y);



    }

    public static Tuple bitcoUNT(int n) {
        Tuple tuple = new Tuple();
        int oneCount = 0;

        int zeroCount = 0;

        for (int i = 0; i <8; i++) {
            int temp = n & 1;

            if (temp == 0) {
                zeroCount++;
            } else{
                oneCount++;
            }

            n = n >> 1;
        }


        tuple.x = zeroCount;
        tuple.y = oneCount;

        return tuple;
    }
}
