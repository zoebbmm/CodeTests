package AlgorithmAndDataStructureTests.LeetCode.Microsoft;

/**
 * Created by weizhou on 11/6/16.
 */
public class Composition {
    GetBytes getBytes;

    ArrayLength arrayLength;

    public Composition() {
        getBytes = new GetBytes();

        arrayLength = new ArrayLength();
    }

    public int composResult(String str) {
        return arrayLength.apply(getBytes.apply(str));
    }
}
