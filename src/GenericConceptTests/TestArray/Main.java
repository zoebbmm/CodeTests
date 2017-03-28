package GenericConceptTests.TestArray;

/**
 * Created by weizhou on 7/9/16.
 */
public class Main {
    public static void main(String[] agrs) {
        int[] emptyarray = new int[3];
        System.out.println(emptyarray[0]);

        int[] arr = new int[5];

        arr[0] = 0;
        arr[1] = 2;
        arr[2] = 0;

        int[] arrSource = new int[3];

        arrSource[0] = 0;
        arrSource[1] = 1;
        arrSource[2] = 2;

        int[] arrDes = new int[3];

        System.arraycopy(arrSource, 0, arrDes, 1, 2);

        for (int i : arrDes) {
            System.out.println(i);
        }

//        System.out.println(arr.length);
//
//        int m = 4;
//
//        change(m);
//
//        System.out.println("m: " + m);

    }

    private static void change(int m) {
        m = 5;
    }
}
