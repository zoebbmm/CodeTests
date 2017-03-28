package GenericConceptTests.TestAbstract;;

/**
 * Created by weizhou on 4/15/16.
 */
public class ChildB extends Parent{
    private String notes;

    public ChildB() {
        System.out.println("ChildB constructor");
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void output() {
        System.out.println("ChildB");
    }
}
