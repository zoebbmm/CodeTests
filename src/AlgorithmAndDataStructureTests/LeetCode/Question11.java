package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhou on 7/15/16.
 */
public class Question11 {
    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "DE";

        List<String> result = findAllInterleavings(str1, str2);

        for(String str : result) {
            System.out.println("list: " + str);
        }

    }

    public static List<String> findAllInterleavings(String str1, String str2) {
        List<String> list = new ArrayList<>();

        printAllInterleavings(str1, str2, list, "");

        return list;
    }

    private static void printAllInterleavings(String str1, String str2, List<String> list, String interleavingString){

        //If string 1 is null then reverseinteger string 2 and return
        if(str1 == null){
            System.out.println(str2);
            return;
        }

        //If string 2 is null then reverseinteger string 1 and return
        if(str2 == null){
            System.out.println(str1);
            return;
        }

        //if string 1 and string 2 length became 0, it means all characters from str1 and str2 is present in interleaving, reverseinteger interleavingString.
        if(str1.length()==0 && str2.length()==0){
            list.add(interleavingString);
        }

        //pick characters from string 1 until string 1 length is empty.
        if(str1.length() != 0){
            //pick character from string 1 and append it in interleavingString string. In next recursive call remove picked character from string 1.
            printAllInterleavings(str1.substring(1), str2, list, interleavingString + str1.charAt(0));
        }

        //pick characters from string 2 until string 2 length is empty.
        if(str2.length() != 0){
            //pick character from string 2 and append it in interleavingString string. In next recursive call remove picked character from string 2.
            printAllInterleavings(str1, str2.substring(1), list, interleavingString + str2.charAt(0));
        }
    }
}
