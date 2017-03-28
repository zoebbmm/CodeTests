package AlgorithmAndDataStructureTests.LeetCode.Question181;

import java.util.List;

/**
 * Created by weizhou on 8/11/16.
 */
public class Main {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth){
        if(nestedList==null||nestedList.size()==0)
            return 0;

        int sum=0;
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                sum += helper(ni.getList(), depth+1);
            }
        }

        return sum;
    }
}
