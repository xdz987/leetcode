package 链表.q24_2_两两交换链表中的节点;

import 树.二叉搜索树.ListNode;

/**
 * 方式二：递归
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextSwap = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextSwap);

        return newHead;
    }
}
