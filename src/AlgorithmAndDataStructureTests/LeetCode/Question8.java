package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by weizhou on 7/14/16.
 */
public class Question8 {
    public Set<Map.Entry<Integer, Integer>> findVertialSums(TreeNode root) {
        if (root == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        impl(root, map, 0);

        Set<Map.Entry<Integer, Integer>> result = map.entrySet();

        return result;
    }

    private void impl(TreeNode root, HashMap<Integer, Integer> map, int height) {
        if (root == null) return;

        impl(root.left, map, height - 1);

        int prevSum = map.containsKey(height) ? 0 : map.get(height);
        map.put(height, prevSum + root.data);

        impl(root.right, map, height + 1);
    }
}
