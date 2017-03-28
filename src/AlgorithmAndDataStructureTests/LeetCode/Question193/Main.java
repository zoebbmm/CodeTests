package AlgorithmAndDataStructureTests.LeetCode.Question193;

/**
 * Created by weizhou on 8/17/16.
 */
public class Main {
    public static void main(String[] args) {
        NestedIntList nestedIntList = new NestedIntList();
        String input = "[123,[456,[789]]]";
        NestedIntList result = nestedIntList.miniParser(input);
        System.out.println(result.toString());
    }
}
