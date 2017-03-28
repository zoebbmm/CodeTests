package GenericConceptTests.TestInheritance;

/**
 * Created by weizhou on 6/10/16.
 */
public class Parent {
    protected String str;
    public Parent() {
        System.out.println("Parent");
        this.str = "root string";
        System.out.println(str);
    }
}
