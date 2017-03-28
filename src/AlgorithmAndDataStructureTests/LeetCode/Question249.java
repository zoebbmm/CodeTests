package AlgorithmAndDataStructureTests.LeetCode;

import java.util.Random;

/**
 * Created by weizhou on 10/29/16.
 */
public class Question249 {
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    Random r=null;
    Node h=null;
    public Question249(Node head) {
        r = new Random();
        h = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count=1;
        Node p = h;
        int result = 0;
        while(p!=null){
            if(r.nextInt(count)==0)
                result= p.data;
            count++;
            p = p.next;
        }
        return result;
    }
}
