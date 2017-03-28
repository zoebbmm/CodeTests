package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question214 {
    public static void main(String[] agrs) {
        String version1 = "1.5";

        String version2 = "1.15";

        System.out.println(compareVersion(version1, version2));
    }
    public static int compareVersion(String version1, String version2) {
        String delim = "[.]";
        String[] v1 = version1.split(delim);
        String[] v2 = version2.split(delim);

        int i = 0;
        int j = 0;

        while (i < v1.length && j < v2.length) {
            int seg1 = Integer.parseInt(v1[i]);
            int seg2 = Integer.parseInt(v2[j]);

            if (seg1 > seg2) {
                return 1;
            } else if (seg1 < seg2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        while (i < v1.length) {
            int seg1 = Integer.parseInt(v1[i]);
            if (seg1 != 0) {
                return 1;
            } else {
                i++;
            }
        }

        while (j < v2.length) {
            int seg2 = Integer.parseInt(v2[j]);
            if (seg2 != 0) {
                return -1;
            } else {
                j++;
            }
        }

        return 0;
    }
}
