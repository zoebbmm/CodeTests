package AlgorithmAndDataStructureTests.TestBinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 5/25/16.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(4);
        list.add(7);
        list.add(10);
        list.add(11);
        list.add(45);
        list.add(50);
        list.add(59);
        list.add(60);
        list.add(66);
        list.add(69);
        list.add(70);
        list.add(79);

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(list, 60);

    }
}
