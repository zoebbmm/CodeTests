package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 12/13/16.
 */
public class Question67FollowUp1 {
    public static void main(String[] agrs) {
        System.out.println(validIPAddress("172.16.254.1"));

        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));

    }
    public static String validIPAddress(String IP) {
        if(isValidIPv4(IP)) return "IPv4";
        else if(isValidIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    public static boolean isValidIPv4(String ip) {
        if(ip.length()<7) return false;
        if(ip.charAt(0)=='.') return false;
        if(ip.charAt(ip.length()-1)=='.') return false;
        String[] tokens = ip.split("[.]");
        if(tokens.length!=4) return false;
        for(String token:tokens) {
            if(!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    public static boolean isValidIPv4Token(String token) {
        if(token.startsWith("0") && token.length()>1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if(parsedInt<0 || parsedInt>255) return false;
            if(parsedInt==0 && token.charAt(0)!='0') return false;
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isValidIPv6(String ip) {
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] tokens = ip.split(":");
        if(tokens.length!=8) return false;
        for(String token: tokens) {
            if(!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    public static boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c>=48 && c<=57;
            boolean isUppercaseAF = c>=65 && c<=70;
            boolean isLowerCaseAF = c>=97 && c<=102;
            if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }
}