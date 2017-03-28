package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by weizhou on 10/9/16.
 */
public class Question65 {
    public static void main(String[] agrs) {
        int[][] people = new int[6][];

        people[0] = new int[]{7, 0};
        people[1] = new int[]{4, 4};
        people[2] = new int[]{7, 1};
        people[3] = new int[]{5, 0};
        people[4] = new int[]{6, 1};
        people[5] = new int[]{5, 2};

        reconstructQueue(people);

    }
    public static int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        LinkedList<int[]> list = new LinkedList<int[]>();

        for (int i = 0; i < size; i++) {
            list.add(new int[]{people[i][0], people[i][1], 0});
        }

        int ans[][] = new int[size][];

        for (int i = 0; i < size; i++) {
            Collections.sort(list, new Comparator<int[]>() {
                public int compare (int[] a, int[] b) {
                    if (a[1] == b[1])
                        return a[0] - b[0];
                    return a[1] - b[1];
                }
            });

            int[] head = list.removeFirst();

            ans[i] = new int[]{head[0], head[1] + head[2]};

            for (int[] p : list) {
                if (p[0] <= head[0]) {
                    p[1] -= 1;
                    p[2] += 1;
                }
            }
        }

        return ans;
    }
}
