package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/26/16.
 */
public class Question89 {
    public static void main(String[] agrs) {
        int[] nums = new int[] {7, 2, 5, 10, 8};

        System.out.println(splitArrayBetter(nums, 2));

        int[] nums1 = new int[] {1, 2, 3, 4, 5};

        System.out.println(splitArrayBetter(nums1, 2));
    }

    public static int splitArrayBetter(int[] nums, int m) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = sum/m; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int splitArray(int[] nums, int m){

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int high = sum;
        int low = sum/m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int n = m;

            int count = 0;
            boolean valid = true;

            for (int num : nums) {
                if (num > mid) {
                    valid = false;
                    break;
                }

                if (count + num > mid) {
                    n-=1;
                    count = 0;
                }

                count+= num;

                if (n == 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
