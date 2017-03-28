package GenericConceptTests.TestInterface;

/**
 * Created by weizhou on 1/30/16.
 */
public class Main {
    public static void main(String[] args) {
        Implementation implementation = new Implementation("testHost-Wei");

        Implementation implementation1 = new Implementation("testHost-Zhou");

        Implementation implementation11 = new Implementation("");

        System.out.println(implementation.getHost());

        System.out.println(implementation1.getHost());

        System.out.println(implementation11.getHost());
    }
}
