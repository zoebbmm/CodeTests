package AlgorithmAndDataStructureTests.LeetCode.Microsoft;

import java.util.function.Function;

/**
 * Created by weizhou on 11/1/16.
 */
public class ArrayLength implements Function<byte[], Integer>{
    @Override
    public Integer apply(byte[] bytes) {
        return bytes.length;
    }
}
