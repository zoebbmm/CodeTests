package AlgorithmAndDataStructureTests.chapter3;

import java.util.Stack;

/**
 * Created by weizhou on 7/2/16.
 */
public class Question2 extends Stack<Question2.NodeWithMin>{
    class NodeWithMin {
        int value;

        int min;

        public NodeWithMin(int v, int m) {
            this.value = v;
            this.min = m;
        }
    }

    // Approach-1 O(1) but cost a larger space
    public void push(int value) {
        int min = Math.min(value, min());

        super.push(new NodeWithMin(value, min));
    }

    private int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }
}
