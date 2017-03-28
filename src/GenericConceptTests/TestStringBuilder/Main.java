package GenericConceptTests.TestStringBuilder;

/**
 * Created by weizhou on 11/23/16.
 */
public class Main {
    public static void main(String[] agrs) {
        StringBuilder sb = new StringBuilder("12345");

        System.out.println(sb.toString());

        sb.setLength(3);

        System.out.println(sb.toString());
    }
}
