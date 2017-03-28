package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Arrays;

/**
 * Created by weizhou on 11/21/16.
 */
public class Question111 {
    public static void main(String[] agrs) {
        int[]g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};

        System.out.println(findContentChildren(g, s));

        int[]g1 = new int[]{1, 2};
        int[] s1 = new int[]{1, 2, 3};

        System.out.println(findContentChildren(g1, s1));
    }
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                count++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return count;
    }
}
