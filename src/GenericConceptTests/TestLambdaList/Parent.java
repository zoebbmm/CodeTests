package GenericConceptTests.TestLambdaList;

import java.util.List;
import java.util.UUID;

/**
 * Created by weizhou on 1/24/17.
 */
public class Parent {
    private UUID id;

    private List<Child> childList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
