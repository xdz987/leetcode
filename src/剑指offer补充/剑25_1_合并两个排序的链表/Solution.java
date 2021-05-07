package 剑指offer补充.剑25_1_合并两个排序的链表;

import 链表.ListNode;

/**
 * 方法一：递归
 * Java：100% 44%
 * 复杂度：O(N+M) O(N+M)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode dummy = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newHead.next = l1;
                newHead = newHead.next;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                newHead = newHead.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            newHead.next = l1;
            newHead = newHead.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            newHead.next = l2;
            newHead = newHead.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}