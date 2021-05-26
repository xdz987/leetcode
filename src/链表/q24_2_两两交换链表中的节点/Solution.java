package 链表.q24_2_两两交换链表中的节点;

import 链表.ListNode;

/**
 * 方式一：迭代
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //虚拟头结点，既能保存最开始的Head又能作为pre
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //前倾 1
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            // 2
            ListNode l1 = pre.next;
            // 3
            ListNode l2 = pre.next.next;
            //后继 4
            ListNode succ = l2.next;

            //交换节点的指针 例12345，第一次 21345，第二次 21435
            l1.next = succ;
            l2.next = l1;
            pre.next = l2;

            //指向下一个节点
            pre = l1;
        }

        return dummy.next;
    }

    //二刷
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newHead = dummy;
        while(head!=null && head.next!=null){
            newHead.next = head.next;
            ListNode next = head.next.next;
            head.next.next = head;
            head.next = next;
            head = next;
            newHead = newHead.next.next;

        }
        return dummy.next;
    }
}