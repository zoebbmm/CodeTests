package GenericConceptTests.TestAbstract;;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weizhou on 4/15/16.
 */
public class Main {
    public static void main(String[] args){
        List<Parent> parentList = new ArrayList<>();

        ChildA childA = new ChildA();
        childA.setUserId(UUID.randomUUID());
        childA.setType("child_A");
        childA.setDeviceSerialNumber(UUID.randomUUID().toString());
        childA.output();

        ChildB childB = new ChildB();
        childB.setUserId(UUID.randomUUID());
        childB.setType("child_B");
        childB.setNotes("notes");

        parentList.add(childA);
        parentList.add(childB);

        System.out.println(parentList.get(0).getType());
        System.out.println(parentList.get(1).getType());

        Parent parent = parentList.get(0);
        parent.output();

    }
}
