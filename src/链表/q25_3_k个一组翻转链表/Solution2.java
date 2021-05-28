package 链表.q25_3_k个一组翻转链表;

import 树.二叉搜索树.ListNode;

/**
 * 【二刷作】
 * 方法二：反转前N个节点多次版
 */
public class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        //设立虚拟头节点不断连接反转后的链表。
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        while (true) {
            //不断的反转前K个节点，反转完成后返回{反转后的头节点，反转后的尾结点}
            ListNode[] res = reverseN(head, k);
            newHead.next = res[0];
            newHead = res[1];
            //当尾结点为或者尾结点.next为空，停止反转，返回虚拟头节点.next
            if (res[1] == null || res[1].next == null)
                break;
            head = res[1].next;
        }
        return dummy.next;
    }

    private ListNode[] reverseN(ListNode head, int k) {
        ListNode saveHead = head;
        ListNode pre = null;
        int count = 0;
        while (head != null && count < k) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        //当最后一次反转时，节点数count<K时，递归反转回来参数以count作k
        if (count < k) {
            return reverseN(pre, count);
        } else {
            saveHead.next = head;
            return new ListNode[]{pre, saveHead};
        }
    }
}
