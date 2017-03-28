package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/9/16.
 */
public class Question180FollowUp1 {
    public static void main(String[] agrs) {
        int[] preorder = new int[]{9, 4, 3, 5, 10, 11};

        System.out.println(verifyPreorder(preorder));

        int[] preorder1 = new int[]{9, 3, 4, 5, 10, 11};

        System.out.println(verifyPreorder(preorder1));
    }

    public static boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }

        int i = -1;
        int max = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < max) {
                return false;
            }

            while (i >= 0 && num > preorder[i]) {
                max = preorder[i];
                i--;
            }

            i++;
            preorder[i] = num;
        }

        return true;
    }
}
