package GenericConceptTests.TestRandom;

import java.util.Random;

/**
 * Created by weizhou on 2/25/16.
 */
public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        fileReader.fileReader();

        test();

        int i = new Random().nextInt(6);
        System.out.println(i);

        final int MAX_CHAR = 4;

        String str = "Wei";

        System.out.println(str.length() < MAX_CHAR);


    }

    private static void test() {

    }
}
