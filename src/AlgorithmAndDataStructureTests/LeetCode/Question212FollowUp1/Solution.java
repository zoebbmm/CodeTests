package AlgorithmAndDataStructureTests.LeetCode.Question212FollowUp1;

/**
 * Created by weizhou on 8/27/16.
 */
public class Solution extends Reader4 {
    char[] buf4 = new char[4];
    int start = 0; // inclusive
    int size = 0; // exclusive
    /**
     *@param buf Destination buffer
     *@param n   Maximum number of characters to read
     *@return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int charRead = 0;
        while (charRead < n) {

            // 之前read4()读进buffer里的字符已全部读完
            if (start == size) {
                size = read4(buf4);
                start = 0;
            }

            // 依次把buffer里的字符读进buf里
            while (charRead < n && start < size) {
                buf[charRead++] = buf4[start++];
            }

            // 判断是否到达文件末尾，是的话跳出循环
            if (size < 4)
                break;
        }
        return charRead;
    }
}
