package AlgorithmAndDataStructureTests.LeetCode.Microsoft;

import java.util.function.Function;

/**
 * Created by weizhou on 11/1/16.
 */
public class GetBytes implements Function<String, byte[]>{

    @Override
    public byte[] apply(String s) {
        return s.getBytes();
    }
}
