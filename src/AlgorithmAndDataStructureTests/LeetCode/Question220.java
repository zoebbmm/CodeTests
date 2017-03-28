package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/28/16.
 */
public class Question220 {
    public static void main(String[] agrs) {
        System.out.println(getHint("1807", "7810"));
    }
    public static String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 ||
                guess == null || guess.length() == 0) {
            return "0A0B";
        }

        int numBulls = 0;
        int numCows = 0;
        int[] s = new int[10];
        int[] g = new int[10];

        // Step 1: count the number of bulls
        for (int i = 0; i < secret.length(); i++) {
            char charS = secret.charAt(i);
            char charG = guess.charAt(i);

            if (charS == charG) {
                numBulls++;
            } else {
                s[charS - '0']++;
                g[charG - '0']++;
            }
        }

        // Step 2: count the number of cows
        for (int i = 0; i < 10; i++) {
            numCows += Math.min(s[i], g[i]);
        }

        return numBulls + "A" + numCows + "B";
    }
}
