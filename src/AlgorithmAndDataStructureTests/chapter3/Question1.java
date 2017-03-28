package AlgorithmAndDataStructureTests.chapter3;

/**
 * Created by weizhou on 6/30/16.
 */
public class Question1 {
    private int stackSize = 3;

    private int[] stack = new int[stackSize * 3];

    private int[] stackPointer = {-1, -1, -1};

    // stackNumber: 0, 1, 2
    public void add(int stackNumber, int value) throws Exception {

        if (stackPointer[stackNumber] + 1 >= stackSize) {
            throw new Exception("out of space");
        }

        stackPointer[stackNumber]++;
        stack[stackIndex(stackNumber)] = value;
    }

    public int pop(int stackNumber) throws Exception {

        if (stackPointer[stackNumber] < 0) {
            throw new Exception("The stack is empty");
        }
        int value = stack[stackIndex(stackNumber)];
        stackPointer[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) {
        int value = stack[stackIndex(stackNumber)];

        return value;
    }

    public int size(int stackNumber) {
        return stackPointer[stackNumber] + 1;
    }

    public Boolean isEmpty(int stackNumber) {
        return stackPointer[stackNumber] == -1;
    }

    private int stackIndex(int stackNumber) {
        return stackNumber * stackSize + stackPointer[stackNumber];
    }

}
