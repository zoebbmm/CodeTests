package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/7/16.
 */
public class Question173 {
    public static void main(String[] agrs) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }
}
