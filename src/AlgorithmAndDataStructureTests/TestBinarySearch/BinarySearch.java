package AlgorithmAndDataStructureTests.TestBinarySearch;

import java.util.List;

/**
 * Created by weizhou on 5/25/16.
 */
public class BinarySearch {
    //O(logN)
    public Boolean search(List<Integer> list, int target) {
        boolean isFound = false;

        int size = list.size();

        int highIndex = size - 1;

        int lowIndex = 0;

        int midIndex = (lowIndex + highIndex)/2;

        while (highIndex >= lowIndex) {
            if (target > list.get(midIndex)) {
                lowIndex = midIndex + 1;
                midIndex = (lowIndex + highIndex) / 2;
            } else if (target == list.get(midIndex)) {
                System.out.println(list.get(midIndex));
                System.out.println(midIndex);
                return true;
            } else {
                highIndex = midIndex - 1;
                midIndex = (lowIndex + highIndex)/2;
            }
        }

        return isFound;
    }
}
