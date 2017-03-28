package AlgorithmAndDataStructureTests.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by weizhou on 8/10/16.
 */
public class Question28FollowUp1 {
    public static void main(String[] agrs) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next = new Node(5);
        l1.next = new Node(8);

        Node l2 = new Node(2);
        l2.next = new Node(6);
        l2.next = new Node(9);

        Node l3 = new Node(0);
        l3.next = new Node(4);
        l3.next = new Node(7);

        List<Node> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(mergeKLists(list).next.next.next.data);

    }

    /**
     * Suppose the total number of nodes is n The total time complexity if (n * log k) .For a priority queue, insertion takes logK time
     * @param lists
     * @return
     */
    public static Node mergeKLists(List<Node> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<Node> queue= new PriorityQueue<Node>(lists.size(),new Comparator<Node>(){
            @Override
            public int compare(Node o1,Node o2){
                if (o1.data<o2.data)
                    return -1;
                else if (o1.data==o2.data)
                    return 0;
                else
                    return 1;
            }
        });

        Node dummy = new Node(0);
        Node tail=dummy;

        for (Node node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    /**
     * Time - O(nlog^n)
     * @param lists
     * @return
     */
    public static Node mergeKListsMergeSort(Node[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static Node partion(Node[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            Node l1=partion(lists,s,q);
            Node l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static Node merge(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.data<l2.data){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
