package GenericConceptTests.TestConstructor;

/**
 * Created by weizhou on 10/31/16.
 */
public class MyClass {
    private MyClass() {
        System.out.println("MyClass can not be instantiated with single private constructor");
    }

    public static MyClass getInstance() {
        return new MyClass();
    }
}
