package AlgorithmAndDataStructureTests.LeetCode.Question212;

/**
 * Created by weizhou on 8/27/16.
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int charsRead = 0;
        char[] buf4 = new char[4];

        while (!eof && charsRead < n) {
            int size = read4(buf4);
            if (size < 4) {
                eof = true;
            }

            if (charsRead + size > n) {
                size = n - charsRead;
            }

            System.arraycopy(buf4, 0, buf, charsRead, size);
            charsRead += size;
        }

        return charsRead;
    }
}
