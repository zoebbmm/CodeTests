package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Stack;

/**
 * Created by weizhou on 8/25/16.
 */
public class Question215 {
    static class Node{
        int level;
        int len;
        public Node(int lev, int len){
            this.level = lev;
            this.len = len;
        }
    }

    public static void main(String[] agrs) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        System.out.println(lengthLongestPath(input));
    }

    public static int lengthLongestPath(String input) {
        if(input==null||input.length()==0)
            return 0;

        int max=0;

        String[] arr = input.split("\n");

        Stack<Node> stack = new Stack<Node>();

        for(int i=0; i<arr.length; i++){
            String s = arr[i];

            int count=0;
            int j=0;
            while(j<s.length()-1){
                //System.out.println("first " + s.substring(j, j+2));
                if(s.substring(j, j+1).equals("\t")){

                    j++;
                    count++;
                }else{
                    break;
                }
            }

            while(!stack.isEmpty() && count <=stack.peek().level){
                stack.pop();
            }

            if(s.contains(".")){
                if(stack.isEmpty()){
                    max = Math.max(max, s.length()-count);
                }else{
                    max = Math.max(max, stack.peek().len+s.length()-count);
                }
            }else{
                if(stack.isEmpty()){
                    stack.push(new Node(count, s.length()-count+1));
                }else{
                    stack.push(new Node(count, stack.peek().len + s.length()-count+1));
                }
            }
        }

        return max;
    }
}
