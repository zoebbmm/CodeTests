package AlgorithmAndDataStructureTests.LeetCode.Question15FollowUp1;

/**
 * Created by weizhou on 10/30/16.
 */
public class Solution {
    public DoublyLinkedListNode addLists(DoublyLinkedListNode l1, DoublyLinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 > len2) {
            l2 = padListWithZeros(l2, len1 - len2);
        } else {
            l1 = padListWithZeros(l1, len2 - len1);
        }

        PartialSum sum = addListHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.partialSum;
        } else {
            DoublyLinkedListNode result = insertBefore(sum.partialSum, sum.carry);
            return result;
        }
    }

    private PartialSum addListHelper(DoublyLinkedListNode l1, DoublyLinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum result = new PartialSum();

            return result;
        }

        PartialSum sum = addListHelper(l1.next, l2.next);

        int val = sum.carry + l1.val + l2.val;

        DoublyLinkedListNode curSumNode = insertBefore(sum.partialSum, val % 10);

        sum.partialSum = curSumNode;
        sum.carry = val / 10;

        return sum;
    }

    private int length(DoublyLinkedListNode node) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    private DoublyLinkedListNode padListWithZeros(DoublyLinkedListNode node, int paddings) {
        DoublyLinkedListNode head = node;

        for (int i = 0; i < paddings; i++) {
            DoublyLinkedListNode zero = new DoublyLinkedListNode(0, null, null);
            head.prev = zero;
            zero.next = head;

            head = zero;
        }

        return head;
    }

    private DoublyLinkedListNode insertBefore(DoublyLinkedListNode partialSumNode, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data, null, null);

        if (partialSumNode != null) {
            partialSumNode.prev = node;

            node.next = partialSumNode;
        }

        return node;
    }
}
