package AlgorithmAndDataStructureTests.LeetCode.Question200;

/**
 * Created by weizhou on 8/21/16.
 */
public class Main {
    public static void main(String[] agrs) {
        RandomizedCollection collection = new RandomizedCollection();

        collection.insert(1);
        collection.insert(1);
        collection.insert(2);
        collection.insert(2);
        collection.insert(3);

//        collection.getRandom();

        collection.remove(1);
        collection.remove(2);

    }
}
