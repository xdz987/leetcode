package 链表.q24_2_两两交换链表中的节点;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 *
 */
class SwapPairs {
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
}