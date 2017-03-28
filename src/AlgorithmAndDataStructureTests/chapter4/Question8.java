package AlgorithmAndDataStructureTests.chapter4;

/**
 * Created by weizhou on 7/4/16.
 */
public class Question8 {
    // Time - O(n + km)
    public Boolean isSubtree(Node rootT1, Node rootT2) {
        if (rootT2 == null) return true;

        if (rootT1.value == rootT2.value) {
            return isTreeMatches(rootT1, rootT2);
        }

        return isSubtree(rootT1.left, rootT2) || isSubtree(rootT1.right, rootT2);
    }

    private Boolean isTreeMatches(Node rootT1, Node rootT2) {
        if (rootT1 == null && rootT2 == null) return true;

        if (rootT1 == null || rootT2 == null) return false;

        if (rootT1.value != rootT2.value) {
            return false;
        } else {
            return isTreeMatches(rootT1.left, rootT2.left) && isTreeMatches(rootT1.right, rootT2.right);
        }
    }
}
