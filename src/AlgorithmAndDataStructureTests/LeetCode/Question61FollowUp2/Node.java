package AlgorithmAndDataStructureTests.LeetCode.Question61FollowUp2;

import java.util.ArrayList;

/**
 * Created by weizhou on 9/23/16.
 */
public class Node {
    int num;
    ArrayList<Node> list;
    char symbol;
    boolean isList;

    public Node(char s){
        symbol=s;
    }

    public Node(int n){
        list = new ArrayList<Node>();
        isList=true;
        num=n;
    }

    public String toString(){
        String s = "";
        if(isList){
            s += num + ":" + list.toString();
        }else{
            s += symbol;
        }
        return s;
    }
}
