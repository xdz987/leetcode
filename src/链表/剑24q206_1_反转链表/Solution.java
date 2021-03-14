package 链表.剑24q206_1_反转链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList reverseList = new ReverseList();
        head = reverseList.reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 反转单链表
 * 1.递归实现
 * 2.迭代实现
 */
class ReverseList {
    //递归实现
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }
    //迭代实现
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode succ = cur.next;
            //---上面完成初始化：pre前 cur中 succ后---
            cur.next = pre;
            pre = cur;
            cur = succ;
        }
        return pre;
    }
}
