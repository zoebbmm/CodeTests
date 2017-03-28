package AlgorithmAndDataStructureTests.LeetCode.Question53FollowUp1;

import java.util.List;

/**
 * Created by weizhou on 7/20/16.
 */
public class NestedInteger {
    int integer;
    List<NestedInteger> list;

    public NestedInteger() {
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public void setList(List<NestedInteger> list) {
        this.list = list;
    }

    public Boolean isInteger() {
        return this.getClass().isInstance(Integer.class);
    }
}
