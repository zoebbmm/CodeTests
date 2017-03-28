package GenericConceptTests.TestString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by weizhou on 4/21/16.
 */
public class Main {
    public static void main(String[] args) {
        String sss = "firstName";

        System.out.println(sss.toUpperCase());
        StringBuilder sb = new StringBuilder();
        sb.append("r1");
        change(sb);

        System.out.println(sb.toString());


        System.out.println((String)null);
        String a = "b";
        String b = null;

        String c = "a";
        String d = "c";

        List<String> test = new ArrayList<>();
        test.add(a);
        test.add(b);
        test.add(c);
        test.add(d);

        test.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }else if (o1 == null && o2 != null) {
                    return 1;
                } else if (o1 != null && o2 == null) {
                    return -1;
                } else {
                    return o2.compareTo(o1);
                }
            }
        });


        List<String> result = new ArrayList<>(test);

        for (String s : result) {
            System.out.println(s);
        }

//        String s1 = "a";
//        System.out.println(s1.substring(0, 0));
//
//        String s = " 1+2";
//        System.out.println(s.length());
//
//        String delim = "[ ]+";
//        s = s.replaceAll(delim, "");
//        System.out.println(s.length());
//
//        String ss = "hello";
//
//        String format = String.format("%10s", ss);
//
//        System.out.println(format.length());
//
//        String test = ")";
//        System.out.println(test.substring(1));
//
//        String str = "BiPAP S/T";
//        System.out.println(str.toLowerCase());
//
//        String str1 = "BiPAP A40";
//        System.out.println(str1.toLowerCase());
//        String str2 = "BiPAP A30";
//        System.out.println(str2.toLowerCase());
//
//        String str3 = "SystemOne";
//        System.out.println(str3.toLowerCase());
//
//        String str4 = "wei ";
//        char[] chars = str4.toCharArray();
//        System.out.println(chars.length);
//
//        for(char c : chars) {
//            System.out.println(c);
//        }
//
//        int i = chars[3];
//        System.out.println(i);
//
//        System.out.println(str4.substring(1, 1));
//
//        String str5 = "mmc";
//
//        System.out.println("index: " + str5.indexOf('m'));
    }

    private static void change(StringBuilder sb) {
        sb.append("##");
    }
}
