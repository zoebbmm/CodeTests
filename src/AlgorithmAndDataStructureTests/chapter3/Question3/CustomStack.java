package AlgorithmAndDataStructureTests.chapter3.Question3;

/**
 * Created by weizhou on 7/3/16.
 */
public class CustomStack {
    int capacity;
    int size = 0;

    StackNode top;
    StackNode bottom;

    public CustomStack(int capacity) {
        this.capacity = capacity;
    }

    public Boolean push(int value) {
        if (size >= capacity) return false;
        StackNode node = new StackNode(value);

        join(node, top);

        top = node;

        size++;

        if (size == 1) bottom = node;

        return true;
    }

    public int pop() {
        int value = top.value;

        size --;

        top = top.below;

        return value;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public Boolean isFull() {
        return this.size == capacity;
    }

    public int removeBottom() {
        int value = bottom.value;

        bottom = bottom.above;

        if (bottom != null) {
            bottom.below = null;
        }

        size--;

        return value;
    }

    private void join(StackNode newNode, StackNode currentTop) {
        if (newNode != null) newNode.below = currentTop;
        if (currentTop != null) currentTop.above = newNode;
    }
}
