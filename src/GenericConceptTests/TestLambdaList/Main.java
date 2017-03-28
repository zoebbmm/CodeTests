package GenericConceptTests.TestLambdaList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weizhou on 1/24/17.
 */
public class Main {
    public static void main(String[] agrs) {
        Child child1 = new Child();
        child1.setChildId(UUID.randomUUID());
        child1.setB("child1");

        Child child2 = new Child();
        child2.setChildId(UUID.randomUUID());
        child2.setB("child2");

        List<Child> childList = new ArrayList<>();
        childList.add(child1);
        childList.add(child2);

        Parent parent1 = new Parent();
        parent1.setId(UUID.randomUUID());
        parent1.setChildList(childList);

        Parent parent2 = new Parent();
        parent2.setId(UUID.randomUUID());
        parent2.setChildList(childList);

        List<Parent> parentList = new ArrayList<>();
        parentList.add(parent1);
        parentList.add(parent2);

//        List<List<Object>> list = ...
//        List<Object> flat =
//                list.stream()
//                        .flatMap(List::stream)
//                        .collect(Collectors.toList());

//        rsp.getFirstNodes().stream().map(FirstNode::getSndNodes)
//                .filter(sndNode-> sndNode.isValid())
//                .forEach(sndNode->{
//                    // No do the sndNode parsing operation Here.
//                })

        List<Child> result = new ArrayList<>();

        for (Parent parent : parentList) {
            List<Child> children = parent.getChildList();
            for (Child child : children) {
                child.setChildId(parent.getId());
                result.add(child);
            }
        }


    }
}
