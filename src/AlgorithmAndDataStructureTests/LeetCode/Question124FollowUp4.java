package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 9/24/16.
 */
public class Question124FollowUp4 {
    public TreeNodeParent lowestCommonAncestor(TreeNodeParent p, TreeNodeParent q) {
        int h1 = getHeight(p);
        int h2 = getHeight(q);

        if (h1 > h2) {
            int temp = h1;
            h1 = h2;
            h2 = temp;

            TreeNodeParent tempNode = p;
            p = q;
            q = tempNode;
        }

        int dh = h2 - h1;

        for (int i = 0; i < dh; i++) {
            q = q.parent;
        }

        while (p != null && q != null) {
            if (p == q) return p;
            p = p.parent;
            q = q.parent;
        }

        return null;
    }

    private int getHeight(TreeNodeParent n) {
        int height = 0;

        while (n != null) {
            height ++;

            n = n.parent;
        }

        return height;
    }
}
