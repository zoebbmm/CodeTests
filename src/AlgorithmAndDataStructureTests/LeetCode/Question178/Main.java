package AlgorithmAndDataStructureTests.LeetCode.Question178;

/**
 * Created by weizhou on 8/6/16.
 */
public class Main {
    public static void main(String[] agrs) {
        String[] dic = {"deer", "door", "cake", "card"};

        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dic);

        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
        System.out.println(validWordAbbr.isUnique("cake"));


    }
}
