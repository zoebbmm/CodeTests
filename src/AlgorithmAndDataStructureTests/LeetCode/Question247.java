package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 10/26/16.
 */
public class Question247 {
    public static void main(String[] agrs) {
//        System.out.println(strongPasswordCheckerr("aaa"));
//        System.out.println(strongPasswordCheckerr("aA66aA"));
//        System.out.println(strongPasswordCheckerr("aaabbcccdd0000"));
//
//        System.out.println(strongPasswordCheckerBetter("aaa"));
//        System.out.println(strongPasswordCheckerBetter("aA66aA"));
        System.out.println(strongPasswordCheckerBetter("aaabbcccdd0000"));
        System.out.println(strongPasswordCheckerBetter("1Abababcaaaabababababa"));



    }

    public static int strongPasswordCheckerBetter(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];

        for (int i = 0; i < arr.length;) {
            if (Character.isLowerCase(carr[i])) a = 0;
            if (Character.isUpperCase(carr[i])) A = 0;
            if (Character.isDigit(carr[i])) d = 0;

            int j = i;
            while (i < carr.length && carr[i] == carr[j]) {
                i++;
            }
            arr[j] = i - j;
        }

        int total_missing = (a + A + d);

        if (arr.length < 6) {
            res += total_missing + Math.max(0, 6 - (arr.length + total_missing));

        } else {
            int over_len = Math.max(arr.length - 20, 0), left_over = 0;
            res += over_len;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over_len > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(over_len, k);
                    over_len -= k;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && over_len > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over_len;
                    over_len -= need;
                }

                if (arr[i] >= 3) left_over += arr[i] / 3;
            }

            res += Math.max(total_missing, left_over);
        }

        return res;
    }

    public static int strongPasswordCheckerr(String s) {

        if(s.length()<2) return 6-s.length();

        //Initialize the states, including:
        // current ending character(end),
        // existence of:
        // lowercase letter(lower),
        // uppercase letter(upper),
        // digit(digit)
        // and number of replicates for ending character(end_rep)
        char end = s.charAt(0);
        boolean upper = end>='A'&&end<='Z', lower = end>='a'&&end<='z', digit = end>='0'&&end<='9';

        //Also initialize:
        // the number of modification for repeated characters,
        // total number needed for eliminate all consequnce 3 same character by replacement(change),
        // and potential maximun operation of deleting characters(delete).
        //
        // Note:
        // delete[0] means maximum number of reduce 1 replacement operation by 1 deletion operation,
        // delete[1] means maximun number of reduce 1 replacement by 2 deletion operation,
        // delete[2] is no use here.
        int end_rep = 1, change = 0;
        int[] delete = new int[3];

        for(int i = 1;i<s.length();++i){
            if(s.charAt(i)==end) ++end_rep;
            else{
                change+=end_rep/3;
                if(end_rep/3>0) ++delete[end_rep%3];
                //updating the states
                end = s.charAt(i);
                upper = upper||end>='A'&&end<='Z';
                lower = lower||end>='a'&&end<='z';
                digit = digit||end>='0'&&end<='9';
                end_rep = 1;
            }
        }
        change+=end_rep/3;
        if(end_rep/3>0) ++delete[end_rep%3];

        //The number of replcement needed for missing of specific character(lower/upper/digit)
        int check_req = (upper?0:1)+(lower?0:1)+(digit?0:1);

        if(s.length()>20){
            int del = s.length()-20;

            //Reduce the number of replacement operation by deletion
            if(del <= delete[0]){
                change-=del;
            } else if(del-delete[0] <= 2*delete[1]) {
                change -= delete[0] + (del-delete[0])/2;
            } else {
                change -= delete[0] + delete[1] + (del-delete[0]-2*delete[1])/3;
            }

            return del+Math.max(check_req,change);
        } else {
            return Math.max(6-s.length(), Math.max(check_req, change));
        }
    }
}
