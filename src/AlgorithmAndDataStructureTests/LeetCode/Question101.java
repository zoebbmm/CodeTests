package AlgorithmAndDataStructureTests.LeetCode;

/**
 * Created by weizhou on 8/10/16.
 */
public class Question101 {
     class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
      }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // step 1: copy node and insert behind
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            RandomListNode nextNode = p.next;
            p.next = copy;
            copy.next = nextNode;
            p = nextNode;
        }

        // step 2: copy random pointers
        p = head;
        while (p != null) {
            RandomListNode nextNode = p.next.next;
            if (p.random != null) {
                p.next.random = p.random.next;
            } else {
                p.next.random = null;
            }

            p = nextNode;
        }

        // step 3: break down the linked list and recover the original and new linked list
        p = head;
        RandomListNode newHead = p.next;

        while (p != null) {
            RandomListNode q = p.next;
            p.next = q.next;
            if (q.next != null) {
                q.next = p.next.next;
            }

            p = p.next;
        }

        return newHead;

    }
}
