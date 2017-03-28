package AlgorithmAndDataStructureTests.LeetCode.Question61FollowUp2;

import java.util.Stack;

/**
 * Created by weizhou on 9/23/16.
 */
public class DecodeString {
    public String decodeString(String s) {
        int i = 0;
        Stack<Node> stack = new Stack<Node>();

        stack.push(new Node(1));

        String t = "";
        while (i < s.length()) {
            char c = s.charAt(i);

            // new Node
            if (c >= '0' && c <= '9') {
                t += c;

            } else if (c == '[') {
                if (t.length() > 0) {
                    int num = Integer.parseInt(t);
                    stack.push(new Node(num));
                    t = "";
                }
            } else if (c == ']') {
                Node top = stack.pop();

                if (stack.isEmpty()) {

                } else {
                    stack.peek().list.add(top);
                }

            } else {
                stack.peek().list.add(new Node(c));
            }

            i++;
        }

        return getString(stack.peek());
    }

    public String getString(Node node){
        String s="";
        if(node.isList){
            for(int i=0; i<node.num; i++){
                for(Node t: node.list)
                    s+= getString(t);
            }
        }else{
            s+=node.symbol;
        }

        return s;
    }
}
