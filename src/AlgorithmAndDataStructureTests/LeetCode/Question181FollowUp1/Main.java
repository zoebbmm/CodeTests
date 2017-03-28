package AlgorithmAndDataStructureTests.LeetCode.Question181FollowUp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 8/11/16.
 */
public class Main {
    public int DFS(List<NestedInteger> nestedList, int intSum) {
        //关键点在于把上一层的integer sum传到下一层去，这样的话，接下来还有几层，每一层都会加上这个integer sum,也就等于乘以了它的层数
        List<NestedInteger> nextLevel = new ArrayList<>();
        int listSum = 0;
        for (NestedInteger list : nestedList) {
            if (list.isInteger()) {
                intSum += list.getInteger();
            } else {
                nextLevel.addAll(list.getList());
            }
        }
        listSum = nextLevel.isEmpty() ? 0 : DFS(nextLevel, intSum);
        return listSum + intSum;
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        return DFS(nestedList, 0);
    }
}
