package 链表.q203_1_移除链表元素;

import 链表.ListNode;

/**
 * 方式二：递归
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        head.next = removeElements(head.next,val);
        if (head.val == val)
            return head.next;
        else
            return head;
    }
}
