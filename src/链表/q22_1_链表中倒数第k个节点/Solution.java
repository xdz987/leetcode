package 链表.q22_1_链表中倒数第k个节点;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 *
 */
class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}