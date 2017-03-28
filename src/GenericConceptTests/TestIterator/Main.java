package GenericConceptTests.TestIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by weizhou on 7/20/16.
 */
public class Main {
    public static void main(String[] args) {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };


        List<Integer> list = new ArrayList<>();
    }
}
