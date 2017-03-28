package GenericConceptTests.TestInheritance;

/**
 * Created by weizhou on 6/10/16.
 */
public class Child extends Parent{
    private String str;

    public static void main(String[] args) {
        new Child();
        new Child("Child constructor with args");
    }

    public Child() {
        this.str = "changed String";
        System.out.println(this.str);
        super.str = "changed root string";
        System.out.println(super.str);
        System.out.println("Child constructor without args");
    }

    public Child(String str) {
        System.out.println(str);
    }
}
