package GenericConceptTests.TestList;

import java.util.LinkedList;

/**
 * Created by weizhou on 1/27/16.
 */
public class Main {

    public static void main(String[] args) {
//        UUID uuid = null;
//
//        String strUUID = uuid.toString();
//
//        System.out.println(strUUID);

//        List<String> stringList = null;
//
//        List<String> stringList1 = new ArrayList<>();
//
//        System.out.println(stringList1.isEmpty());
//
//        stringList1.add(null);
//
//        System.out.println(stringList1.size());

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            System.out.println(list.get(i));

            list.removeFirst();

            System.out.println(list.get(i));
        }


    }
}
