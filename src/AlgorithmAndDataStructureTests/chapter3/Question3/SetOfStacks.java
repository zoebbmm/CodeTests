package AlgorithmAndDataStructureTests.chapter3.Question3;

import java.util.ArrayList;

/**
 * Created by weizhou on 7/3/16.
 */
public class SetOfStacks {
    ArrayList<CustomStack> stacks = new ArrayList<>();

    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push (int value) {
        CustomStack stack = getLastStack();

        if (stack != null && stack.isFull()) {
            stack.push(value);
        } else {
            CustomStack newStack = new CustomStack(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop() {
        CustomStack stack = getLastStack();

        int value = stack.pop();

        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, Boolean removeTop) {
        CustomStack stack = stacks.get(index);

        int removedItem;

        if (removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }

        return removedItem;
    }

    private CustomStack getLastStack() {
        if (stacks.isEmpty()) return null;

        return stacks.get(stacks.size() - 1);
    }
}
