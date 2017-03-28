package AlgorithmAndDataStructureTests.chapter11;

/**
 * Created by weizhou on 7/9/16.
 */
public class Question5 {
    public int findLocationOfAString(String[] strings, String targetString) {

        if (targetString == "" || strings == null || targetString == null) return -1;

        return impl(strings, 0, strings.length - 1, targetString);
    }

    private int impl(String[] strings, int startIndex, int endIndex, String targetString) {
        if (startIndex > endIndex) return -1;

        int midIndex = (startIndex + endIndex) / 2;

        if (strings[midIndex].equals(targetString)) return midIndex;

        int leftIndex = 0;
        int rightIndex = 0;

        if (strings[midIndex] == "") {
            leftIndex = midIndex - 1;
            rightIndex = midIndex + 1;

            while (leftIndex >= 0 && rightIndex <= endIndex) {
                if (rightIndex <= endIndex && (strings[rightIndex] != "")) {
                    midIndex = rightIndex;
                    break;
                } else if (leftIndex >= startIndex && (strings[leftIndex] != "")) {
                    midIndex = leftIndex;
                    break;
                }

                rightIndex++;
                leftIndex--;
            }
        }

        if (strings[midIndex].compareTo(targetString) < 0) {
            return impl(strings, midIndex + 1, endIndex, targetString);
        } else if (strings[midIndex].compareTo(targetString) > 0) {
            return impl(strings, startIndex, midIndex - 1, targetString);
        } else {
            return midIndex;
        }
    }
}
