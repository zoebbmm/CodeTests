package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/13/16.
 */
public class Question184 {
    public static void main(String[] agrs) {
        System.out.println(rearrangeStringqqqq("daaabbcc", 2));

    }



    public static String rearrangeStringqqqq(String str, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        //把每个出现了的char的个数记下来
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //选出剩下需要出现次数最多又满足条件的字母，即是我们最应该先放的数
            int curt = selectedValue(count, valid, i);
            //如果不符合条件，返回“”
            if (curt == -1) return "";
            //选择好后，count要减少，valid要到下一个k distance之后
            count[curt]--;
            valid[curt] = i + k;
            sb.append((char)('a' + curt));
        }

        return sb.toString();
    }

    public static int selectedValue(int[] count, int[] valid, int i) {
        int select = Integer.MIN_VALUE;
        int val = -1;
        for (int j = 0; j < count.length; j++) {
            if (count[j] > 0 && i >= valid[j] && count[j] > select) {
                select = count[j];
                val = j;
            }
        }
        return val;
    }
}
