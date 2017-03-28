package AlgorithmAndDataStructureTests.chapter9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/8/16.
 */
public class Question6 {
    public static void main(String[] args) {

    }

    public static List<String> combinationsOfParantheses(int pairCount) {
        char[] parentheses = new char[pairCount * 2];

        List<String> combinations = new ArrayList<>();

        findCombinations(parentheses, combinations, 3, 3, 0);

        return combinations;
    }

    private static void findCombinations(char[] parentheses, List<String> combinations, int leftRemains, int rightRemains, int count) {
        if (leftRemains < 0 || rightRemains < leftRemains) return;

        if (leftRemains == 0 && rightRemains == 0) {
            String str = String.copyValueOf(parentheses);
            combinations.add(str);
        } else {
            if (leftRemains > 0) {
                parentheses[count] = '(';

                findCombinations(parentheses, combinations, leftRemains-1, rightRemains, count + 1);
            }

            if (rightRemains > 0 && rightRemains > leftRemains) {
                parentheses[count] = ')';
                findCombinations(parentheses, combinations, leftRemains, rightRemains - 1, count + 1);
            }
        }
    }
}
