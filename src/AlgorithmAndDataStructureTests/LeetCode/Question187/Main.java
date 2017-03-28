package AlgorithmAndDataStructureTests.LeetCode.Question187;

/**
 * Created by weizhou on 8/15/16.
 */
public class Main {
    public static void main(String[] agrs) {
        int[] arr = new int[]{1, 2, 3};

        ShuffleSolution shuffleSolution = new ShuffleSolution(arr);

        int[] result = shuffleSolution.shuffle();

        for (int i : result) {
            System.out.println(i);
        }
    }
}
