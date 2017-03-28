package AlgorithmAndDataStructureTests.chapter17.Question5;

/**
 * Created by weizhou on 7/10/16.
 */
public class Question5 {
    public Result countHitAndPseudoHit(String solution, String guess) {
        if (solution.length() != guess.length()) return null;

        Result result = new Result();

        int[] apearingFrequency = new int[4];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                result.hit++;
            } else {
                int matchedColorNumber = matchedColorNumber(solution.charAt(i));
                apearingFrequency[matchedColorNumber]++;
            }
        }

        for (int j = 0; j < guess.length(); j++) {
            if (guess.charAt(j) != solution.charAt(j) && (matchedColorNumber(guess.charAt(j)) >= 0) && (apearingFrequency[matchedColorNumber(guess.charAt(j))] > 0)) {
                result.pseudoHit++;
                apearingFrequency[matchedColorNumber(guess.charAt(j))]--;
            }
        }

        return result;
    }

    private int matchedColorNumber(char colorCharater) {
        switch (colorCharater) {
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'G':
                return 2;
            case 'B':
                return 3;
            default:
                return -1;
        }
    }

}
