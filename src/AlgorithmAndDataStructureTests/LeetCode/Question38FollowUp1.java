package AlgorithmAndDataStructureTests.LeetCode;

import java.util.HashMap;

/**
 * Created by weizhou on 7/16/16.
 */
public class Question38FollowUp1 {
    public String longestRepeatedString(String str) {
        if (str == null || str.length() == 0) return null;

        HashMap<String, Integer> trackingOccurence = new HashMap<>();
        HashMap<String, Integer> trackingLength = new HashMap<>();

        for (int i = str.length(); i >= 1; i--) {
            for (int j = 0; j <= str.length() - i; j++) {
                String sub = str.substring(j, j + i);

                if (trackingOccurence.containsKey(sub)) {
                    trackingOccurence.put(sub, trackingOccurence.get(sub) + 1);

                    if (trackingOccurence.get(sub) >= 2) {
                        trackingLength.put(sub, sub.length());
                    }
                } else {
                    trackingOccurence.put(sub, 1);
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        String longest = "";

        for (String key : trackingLength.keySet()) {
            if (trackingLength.get(key) > maxLength) {
                maxLength = trackingLength.get(key);
                longest = key;
            }
        }

        return longest;
    }

}
