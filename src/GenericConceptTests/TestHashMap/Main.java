package GenericConceptTests.TestHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weizhou on 7/15/16.
 */
public class Main {
    public static void main(String[] args) {
//        HashMap<Integer, String> map = new HashMap<>();
//
//        map.put(1, "a");
//        map.put(2, "b");
//
//        System.out.println(map.get(2));
//
//        map.put(2, "c");
//        System.out.println(map.get(2));
//
//
//        Set<Map.Entry<Integer, String>> set = map.entrySet();
//
//        for (Map.Entry<Integer, String> temp : set) {
//            System.out.println(temp);
//        }

        HashMap<String, Filter> hashMap = new HashMap<>();

        for (Map.Entry<String, Filter> entry : hashMap.entrySet()) {

            String key = entry.getKey();

            if (entry.getValue().getType().equals("date")) {
                // Date date = deserialization...
                //query.addCriteria(Criteria.where(key).is(date));
            } else if (entry.getValue().getType().equals("enum")) {
                // Compliance complaintStatus = deserialization...
                // query.addCriteria(Criteria.where(key).is(complaintStatus));
            }
        }

    }
}
