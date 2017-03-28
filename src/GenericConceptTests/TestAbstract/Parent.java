package GenericConceptTests.TestAbstract;;

import java.util.UUID;

/**
 * Created by weizhou on 4/15/16.
 */
public abstract class Parent {
    private UUID userId;

    private String type;

    public Parent() {
        System.out.println("Parent constructor");
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void output();
}
